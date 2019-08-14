package command;

import controller.validators.RegistrationValidator;
import controller.validators.Validator;
import enums.Role;
import facade.RegistrationFacade;
import model.entity.Guest;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.Map;

import static enums.Attributes.*;
import static enums.Errors.USER_ALREADY_EXISTS;
import static enums.Mappings.HOME;
import static enums.Role.GUEST;

/**
 * Define an object used for executing registration command on RegistrationFacade.
 *
 * @see RegistrationFacade
 */
public class RegistrationCommand implements Command {
    private RegistrationFacade registrationFacade = new RegistrationFacade();

    private final Logger logger = Logger.getLogger(this.getClass());

    /**
     * Method to execute registration actions on HttpServletRequest and HttpServletResponse.
     *
     * @param req  The HttpServletRequest
     * @param resp The HttpServletResponse
     * @return The string value representing mapping value.
     * @see enums.Mappings
     */
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter(NAME.getName());
        String surname = req.getParameter(SURNAME.getName());
        String username = req.getParameter(USERNAME.getName());
        String password = req.getParameter(PASSWORD.getName());
        String age = req.getParameter(AGE.getName());
        String phoneNumber = req.getParameter(PHONE_NUMBER.getName());
        String passportId = req.getParameter(PASSPORT_ID.getName());

        Guest guest = new Guest(name, surname, phoneNumber, passportId,
                username, password);
        guest.setRole(Role.GUEST);

        Validator registrationValidator = new RegistrationValidator(guest, age);
        Map<String, String> errors = registrationValidator.validate();

        if (!errors.isEmpty()) {
            req.setAttribute(ERRORS.getName(), errors);
            return ERRORS.getName();
        } else {
            guest.setAge(Integer.parseInt(age));
            boolean added = false;
            try {
                added = registrationFacade.registerGuest(guest);
            } catch (SQLException e) {
                logger.error(e.getMessage(), e);
            }

            if (added) {
                HttpSession session = req.getSession();
                logger.info("Guest was registered with username: " + username);
                session.setAttribute(GUEST.getName(), username);
                return HOME.getName();
            } else {
                errors.put(USER.getName(), USER_ALREADY_EXISTS.getName());
                req.setAttribute(ERRORS.getName(), errors);
                return ERRORS.getName();
            }
        }
    }
}
