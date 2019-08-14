package facade;

import controller.services.BookingService;
import factories.JDBCConnectionFactory;
import factories.ServiceFactory;
import model.dto.BookingApprovementDTO;
import model.dto.NecessaryRoomDto;
import model.entity.Guest;
import model.entity.Reservation;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;

/**
 * A class that works with BookingService.
 *
 * @see BookingService
 */
public class BookingFacade {
    private BookingService service = ServiceFactory.getInstance().getBookingService();

    /**
     * Method to create booking by using BookingService {@link #service}.
     *
     * @param necessaryRoomDto Object to pass params containing in it.
     * @return Object of BookingApprovementDto.
     * @throws SQLException   If sql exception occurred while processing this request.
     * @throws ParseException If parse exception occurred while processing this request.
     * @see BookingApprovementDTO
     * @see NecessaryRoomDto
     */
    public BookingApprovementDTO booking(NecessaryRoomDto necessaryRoomDto) throws SQLException, ParseException {
        Connection connection = JDBCConnectionFactory.getInstance().getConnection();
        connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
        connection.setAutoCommit(false);
        return service.booking(necessaryRoomDto, connection);
    }

    /**
     * Method to add guest id to created reservation by using BookingService {@link #service}.
     *
     * @param guest       Object to pass params containing in it.
     * @param reservation Object to pass params containing in it.
     * @param connection  Connection to connect to database.
     * @return <code>true</code> if adding was successful; <code>false</code> otherwise.
     * @throws SQLException If sql exception occurred while processing this request.
     * @see Guest
     * @see Reservation
     */
    public boolean addGuestIdToReservation(Guest guest, Reservation reservation, Connection connection) throws SQLException {
        return service.addGuestIdToReservation(guest, reservation, connection);
    }
}
