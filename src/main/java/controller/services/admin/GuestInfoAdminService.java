package controller.services.admin;

import dao.intefaces.GuestDao;
import factories.DaoFactory;
import model.dto.GuestsAdminDto;

import java.sql.SQLException;

/**
 * A class that works with GuestDao.
 *
 * @see GuestDao
 */
public class GuestInfoAdminService {

    private GuestDao guestDao;

    /**
     * Creates a GuestInfoAdminService object and initialize {@link #guestDao}.
     */
    public GuestInfoAdminService() {
        this.guestDao = DaoFactory.getInstance().getGuestDao();
    }

    /**
     * Method to get all guests by using GuestDao {@link #guestDao}.
     *
     * @param guestsAdminDto Object to pass params containing in it.
     * @return Object of GuestAdminDto containing list of guests;
     * @throws SQLException If sql exception occurred while processing this request.
     * @see GuestsAdminDto
     */
    public GuestsAdminDto getAllGuests(GuestsAdminDto guestsAdminDto) throws SQLException {
        return guestDao.getAllGuests(guestsAdminDto);
    }
}
