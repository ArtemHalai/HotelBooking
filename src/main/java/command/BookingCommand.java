package command;

import controller.validators.BookingValidator;
import enums.Role;
import facade.BookingFacade;
import facade.RoomRequestFacade;
import model.dto.BookingApprovementDTO;
import model.dto.NecessaryRoomDto;
import model.dto.RoomRequestDto;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Map;

import static enums.Attributes.*;
import static enums.Errors.NO_AVAILABLE_ROOM;
import static enums.Mappings.GUEST_INFO;
import static enums.Mappings.PAYMENT;

public class BookingCommand extends AbstractCommand {

    private BookingFacade bookingFacade = new BookingFacade();
    private RoomRequestFacade roomRequestFacade = new RoomRequestFacade();

    private final Logger logger = Logger.getLogger(this.getClass());

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        String balcony = req.getParameter("balcony");
        String smoke = req.getParameter("smoke");
        String dateIn = req.getParameter("dateIn");
        String dateOut = req.getParameter("dateOut");
        String roomTypeId = req.getParameter("roomType");
        String priceRange = req.getParameter("priceRange");

        logger.info("User is booking with request parameter: date in - " + dateIn + ", date out - " + dateOut + " and room type id is " +
                roomTypeId);

        BookingValidator validator = new BookingValidator(dateIn, dateOut);
        Map<String, String> errors = validator.validate();
        if (!errors.isEmpty()) {
            req.setAttribute(ERRORS.getName(), errors);
            return ERRORS.getName();
        } else {
            BookingApprovementDTO bookingApprovementDTO = null;
            try {
                NecessaryRoomDto necessaryRoomDto = new NecessaryRoomDto(balcony, smoke, dateIn, dateOut, roomTypeId, priceRange);
                bookingApprovementDTO = bookingFacade.booking(necessaryRoomDto);
            } catch (SQLException | ParseException e) {
                logger.error(e.getMessage());
            }

            if (bookingApprovementDTO != null && bookingApprovementDTO.getReservationId() > 0) {
                logger.info("Reservation with id " + bookingApprovementDTO.getReservationId() + " added in database");
                HttpSession session = req.getSession(false);
                try {
                    RoomRequestDto roomRequestDto = new RoomRequestDto(roomTypeId, dateIn, dateOut);
                    roomRequestFacade.addRoomRequest(roomRequestDto);
                } catch (ParseException | SQLException e) {
                    logger.error(e.getMessage());
                }

                session.setAttribute(ROOM_ID.getName(), bookingApprovementDTO.getRoomId());
                session.setAttribute(RESERVATION_ID.getName(), bookingApprovementDTO.getReservationId());
                session.setAttribute(PRICE.getName(), bookingApprovementDTO.getPrice());

                if (session.getAttribute(Role.GUEST.getName()) != null) {
                    return PAYMENT.getName();
                } else {
                    return GUEST_INFO.getName();
                }
            } else {
                errors.put(AVAILABLE.getName(), NO_AVAILABLE_ROOM.getName());
                req.setAttribute(ERRORS.getName(), errors);
                logger.info("No available room with request parameter: date in - " + dateIn + ", date out - " + dateOut + " and room type id is " +
                        roomTypeId);
                return ERRORS.getName();
            }
        }
    }
}
