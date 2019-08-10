package controller.services;

import factories.DaoFactory;
import dao.intefaces.GuestDao;
import model.dto.GuestDto;
import model.entity.Guest;
import java.sql.SQLException;

public class LoginService {
    private GuestDao guestDao;

    public LoginService() {
        this.guestDao = DaoFactory.getInstance().getGuestDao();
    }

    public Guest guestExist(GuestDto guestDto) throws SQLException {
        return guestDao.guestExists(guestDto);
    }
}
