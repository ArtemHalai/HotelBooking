package controller.services;

import dao.intefaces.GuestDao;
import factories.DaoFactory;
import model.entity.Guest;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * A class that works with GuestDao.
 *
 * @see GuestDao
 */
public class RegistrationService {
    private GuestDao guestDao;

    /**
     * Creates a RegistrationService object and initialize {@link #guestDao}.
     */
    public RegistrationService() {
        this.guestDao = DaoFactory.getInstance().getGuestDao();
    }

    /**
     * Method to register guest by using GuestDao {@link #guestDao}.
     *
     * @param guest Object to pass params containing in it.
     * @param connection Connection object to connect to database.
     * @return <code>true</code> if the guest was registered;
     * <code>false</code> if guest with such username already exists.
     * @throws SQLException If sql exception occurred while processing this request.
     * @see Guest
     */
    public boolean registerGuest(Guest guest, Connection connection) throws SQLException {

        if (guestDao.usernameExists(guest, connection)) {
            connection.rollback();
            connection.close();
            return false;
        }

        if (guestDao.addRegisteredGuest(guest, connection)) {
            connection.commit();
            connection.close();
            return true;
        }

        connection.rollback();
        connection.close();
        return false;
    }
}
