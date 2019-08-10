package controller.services;

import factories.DaoFactory;
import dao.intefaces.GuestDao;
import model.entity.Guest;
import java.sql.SQLException;

public class GuestInfoService {
    private GuestDao guestDao;

    public GuestInfoService() {
        this.guestDao = DaoFactory.getInstance().getGuestDao();
    }

    public int addGuest(Guest guest) throws SQLException {
        return guestDao.addGuest(guest);
    }
}
