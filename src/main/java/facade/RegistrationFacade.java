package facade;

import controller.services.RegistrationService;
import factories.JDBCConnectionFactory;
import factories.ServiceFactory;
import model.entity.Guest;

import java.sql.Connection;
import java.sql.SQLException;

public class RegistrationFacade {
    private RegistrationService service = ServiceFactory.getInstance().getRegistrationService();

    public boolean registerGuest(Guest guest) throws SQLException {
        Connection connection = JDBCConnectionFactory.getInstance().getConnection();
        connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
        connection.setAutoCommit(false);
        return service.registerGuest(guest, connection);
    }
}
