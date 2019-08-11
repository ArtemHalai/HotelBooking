package command;

import controller.validators.GuestInfoValidator;
import controller.validators.Validator;
import enums.Role;
import facade.BookingFacade;
import facade.GuestInfoFacade;
import facade.PaymentFacade;
import factories.JDBCConnectionFactory;
import model.dto.PaymentDto;
import model.entity.Guest;
import model.entity.Reservation;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import static enums.Attributes.*;
import static enums.Errors.SOMETHING_WRONG;
import static enums.Mappings.SUCCESSFUL;
import static enums.Mappings.UNSUCCESSFUL;

public class GuestInfoCommand implements Command {

    private GuestInfoFacade guestInfoFacade = new GuestInfoFacade();
    private PaymentFacade paymentFacade = new PaymentFacade();
    private BookingFacade bookingFacade = new BookingFacade();

    private final Logger logger = Logger.getLogger(this.getClass());

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter(NAME.getName());
        String surname = req.getParameter(SURNAME.getName());
        String age = req.getParameter(AGE.getName());
        String phoneNumber = req.getParameter(PHONE_NUMBER.getName());
        String passportId = req.getParameter(PASSPORT_ID.getName());
        String price = req.getParameter(PRICE.getName());
        String room = req.getParameter(ROOM_ID.getName());
        String reservationId = req.getParameter(RESERVATION_ID.getName());
        String cardNumber = req.getParameter(CARD_NUMBER.getName());
        String cvCode = req.getParameter(CV_CODE.getName());
        String expiryDate = req.getParameter(EXPIRY_DATE.getName());

        Guest guest = new Guest(name, surname, phoneNumber, passportId);
        guest.setRole(Role.GUEST);

        Validator guestInfoValidator = new GuestInfoValidator(guest, cardNumber, cvCode, expiryDate, age);
        Map<String, String> errors = guestInfoValidator.validate();

        HttpSession session = req.getSession();
        session.removeAttribute(ERRORS.getName());
        session.removeAttribute(PRICE.getName());
        session.removeAttribute(RESERVATION_ID.getName());
        session.removeAttribute(ROOM_ID.getName());
        req.setAttribute(ERRORS.getName(), errors);
        req.setAttribute(PRICE.getName(), price);
        req.setAttribute(RESERVATION_ID.getName(), reservationId);
        req.setAttribute(ROOM_ID.getName(), room);

        int guestId = -1;
        if (!errors.isEmpty()) {
            session.setAttribute(ERRORS.getName(), errors);
            session.setAttribute(PRICE.getName(), price);
            session.setAttribute(RESERVATION_ID.getName(), reservationId);
            session.setAttribute(ROOM_ID.getName(), room);
            return ERRORS.getName();
        } else {
            guest.setAge(Integer.parseInt(age));
            try {
                guestId = guestInfoFacade.addGuest(guest);
                logger.info("Guest with id "+guestId+" added in database");
            } catch (SQLException e) {
                logger.error(e.getMessage(), e);
            }

            if (guestId > 0) {
                boolean addedPayment = false;
                boolean addedId = false;

                try {
                    PaymentDto paymentDto = new PaymentDto(Integer.parseInt(room), Double.parseDouble(price),
                            guestId);
                    addedPayment = paymentFacade.addPayment(paymentDto);
                    Guest g = new Guest();
                    g.setGuestId(guestId);
                    Reservation reservation = new Reservation();
                    reservation.setId(Integer.parseInt(reservationId));
                    Connection connection = JDBCConnectionFactory.getInstance().getConnection();
                    addedId = bookingFacade.addGuestIdToReservation(g, reservation, connection);
                } catch (SQLException e) {
                    logger.error(e.getMessage(), e);
                }
                if (addedPayment && addedId)
                    return SUCCESSFUL.getName();
                else
                    return UNSUCCESSFUL.getName();
            } else {
                errors.put(GUEST.getName(), SOMETHING_WRONG.getName());
                session.setAttribute(ERRORS.getName(), errors);
                return ERRORS.getName();
            }
        }
    }
}
