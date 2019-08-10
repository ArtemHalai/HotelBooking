package controller.services;

import dao.intefaces.GuestDao;
import factories.DaoFactory;
import model.entity.Guest;

import java.sql.Connection;
import java.sql.SQLException;

public class RegistrationService {
    private GuestDao guestDao;

    public RegistrationService() {
        this.guestDao = DaoFactory.getInstance().getGuestDao();
    }

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
