package facade;

import controller.services.LoginService;
import factories.ServiceFactory;
import model.dto.GuestDto;
import model.entity.Guest;

import java.sql.SQLException;

public class LoginFacade {
    private LoginService service = ServiceFactory.getInstance().getLoginService();

    public Guest guestExist(GuestDto guestDto) throws SQLException {
        return service.guestExist(guestDto);
    }
}
