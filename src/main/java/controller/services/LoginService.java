package controller.services;

import factories.DaoFactory;
import dao.intefaces.GuestDao;
import model.dto.GuestDto;
import model.entity.Guest;

import java.sql.SQLException;

/**
 * A class that works with GuestDao.
 *
 * @see GuestDao
 */
public class LoginService {
    private GuestDao guestDao;

    /**
     * Creates a LoginService object and initialize {@link #guestDao}.
     */
    public LoginService() {
        this.guestDao = DaoFactory.getInstance().getGuestDao();
    }

    /**
     * Method to check if guest exists by using GuestDao {@link #guestDao}.
     *
     * @param guestDto Object to pass params containing in it.
     * @return Object of Guest.
     * @throws SQLException If sql exception occurred while processing this request.
     * @see GuestDto
     */
    public Guest guestExist(GuestDto guestDto) throws SQLException {
        return guestDao.guestExists(guestDto);
    }
}
