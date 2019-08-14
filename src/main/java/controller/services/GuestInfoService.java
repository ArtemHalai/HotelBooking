package controller.services;

import factories.DaoFactory;
import dao.intefaces.GuestDao;
import model.entity.Guest;

import java.sql.SQLException;

/**
 * A class that works with GuestDao.
 *
 * @see GuestDao
 */
public class GuestInfoService {
    private GuestDao guestDao;

    /**
     * Creates a GuestInfoService object and initialize {@link #guestDao}.
     */
    public GuestInfoService() {
        this.guestDao = DaoFactory.getInstance().getGuestDao();
    }

    /**
     * Method to add guest by using GuestDao {@link #guestDao}.
     *
     * @param guest Object to pass params containing in it.
     * @return int value representing an id of added guest.
     * @throws SQLException If sql exception occurred while processing this request.
     * @see Guest
     */
    public int addGuest(Guest guest) throws SQLException {
        return guestDao.addGuest(guest);
    }
}
