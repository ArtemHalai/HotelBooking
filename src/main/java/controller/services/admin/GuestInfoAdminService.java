package controller.services.admin;

import dao.intefaces.GuestDao;
import factories.DaoFactory;
import model.dto.GuestsAdminDto;

import java.sql.SQLException;

public class GuestInfoAdminService {

    private GuestDao guestDao;

    public GuestInfoAdminService() {
        this.guestDao = DaoFactory.getInstance().getGuestDao();
    }

    public GuestsAdminDto getAllGuests(GuestsAdminDto guestsAdminDto) throws SQLException {
        return guestDao.getAllGuests(guestsAdminDto);
    }
}
