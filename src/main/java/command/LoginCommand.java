package command;

import controller.validators.LoginValidator;
import controller.validators.Validator;
import enums.Role;
import facade.LoginFacade;
import model.dto.GuestDto;
import model.entity.Guest;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.Map;

import static enums.Attributes.*;
import static enums.Errors.USER_DOES_NOT_EXIST;
import static enums.Mappings.HOME;
import static enums.Mappings.HOME_ADMIN;
import static enums.Role.ADMIN;

/**
 * Define an object used for executing login command on LoginFacade.
 *
 * @see LoginFacade
 */
public class LoginCommand implements Command {
    private LoginFacade loginFacade = new LoginFacade();

    private final Logger logger = Logger.getLogger(this.getClass());

    /**
     * Method to execute login action on HttpServletRequest and HttpServletResponse.
     *
     * @param req  The HttpServletRequest
     * @param resp The HttpServletResponse
     * @return The string value representing mapping value.
     * @see enums.Mappings
     */
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        String userName = req.getParameter(USERNAME.getName());
        String password = req.getParameter(PASSWORD.getName());

        Guest guest = null;

        Validator loginValidator = new LoginValidator(userName, password);
        Map<String, String> errors = loginValidator.validate();
        if (!errors.isEmpty()) {
            req.setAttribute(ERRORS.getName(), errors);
            return ERRORS.getName();
        } else {
            try {
                GuestDto guestDto = new GuestDto(userName, password);
                guest = loginFacade.guestExist(guestDto);
            } catch (SQLException e) {
                logger.error(e.getMessage(), e);
            }

            if (guest != null) {
                HttpSession session = req.getSession();

                logger.info("User is logged in with role: " + guest.getRole() + " and username: " + userName);
                if (guest.getRole() != null && guest.getRole().equals(ADMIN)) {
                    session.setAttribute(ADMIN.getName(), userName);
                    return HOME_ADMIN.getName();
                } else {
                    session.setAttribute(Role.GUEST.getName(), userName);
                    return HOME.getName();
                }
            } else {
                errors.put(USER.getName(), USER_DOES_NOT_EXIST.getName());
                req.setAttribute(ERRORS.getName(), errors);
                return ERRORS.getName();
            }
        }
    }
}
