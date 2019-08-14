package facade;

import controller.services.LoginService;
import factories.ServiceFactory;
import model.dto.GuestDto;
import model.entity.Guest;

import java.sql.SQLException;

/**
 * A class that works with LoginService.
 *
 * @see LoginService
 */
public class LoginFacade {
    private LoginService service = ServiceFactory.getInstance().getLoginService();

    /**
     * Method to check if guest exists by using LoginService {@link #service}.
     *
     * @param guestDto Object to pass params containing in it.
     * @return Object of Guest.
     * @throws SQLException If sql exception occurred while processing this request.
     * @see GuestDto
     */
    public Guest guestExist(GuestDto guestDto) throws SQLException {
        return service.guestExist(guestDto);
    }
}
