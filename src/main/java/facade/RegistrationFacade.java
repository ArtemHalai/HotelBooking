package facade;

import controller.services.RegistrationService;
import factories.JDBCConnectionFactory;
import factories.ServiceFactory;
import model.entity.Guest;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * A class that works with RegistrationService.
 *
 * @see RegistrationService
 */
public class RegistrationFacade {
    private RegistrationService service = ServiceFactory.getInstance().getRegistrationService();

    /**
     * Method to register guest by using RegistrationService {@link #service}.
     *
     * @param guest Object to pass params containing in it.
     * @return <code>true</code> if the guest was registered;
     * <code>false</code> if guest with such username already exists.
     * @throws SQLException If sql exception occurred while processing this request.
     * @see Guest
     */
    public boolean registerGuest(Guest guest) throws SQLException {
        Connection connection = JDBCConnectionFactory.getInstance().getConnection();
        connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
        connection.setAutoCommit(false);
        return service.registerGuest(guest, connection);
    }
}
