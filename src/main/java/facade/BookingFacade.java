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

public class BookingFacade {
    private BookingService service = ServiceFactory.getInstance().getBookingService();

    public BookingApprovementDTO booking(NecessaryRoomDto necessaryRoomDto) throws SQLException, ParseException {
        Connection connection = JDBCConnectionFactory.getInstance().getConnection();
        connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
        connection.setAutoCommit(false);
        return service.booking(necessaryRoomDto, connection);
    }

    public boolean addGuestIdToReservation(Guest guest, Reservation reservation, Connection connection) throws SQLException {
        return service.addGuestIdToReservation(guest, reservation, connection);
    }
}
