package command;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static enums.Mappings.LOGGED_IN_VIEW;
import static enums.Role.ADMIN;
import static enums.Role.GUEST;

/**
 * Define an object used for executing logged in command.
 */
public class LoggedInCommand implements Command  {

    private final Logger logger = Logger.getLogger(this.getClass());

    /**
     * Method to execute logged in action on HttpServletRequest and HttpServletResponse.
     *
     * @param request The HttpServletRequest
     * @param response The HttpServletResponse
     * @return The string value representing mapping value.
     * @see enums.Mappings
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        String usernameGuest = (String) request.getSession(false).getAttribute(GUEST.getName());
        String usernameAdmin = (String) request.getSession(false).getAttribute(ADMIN.getName());

        if (usernameGuest != null)
            logger.info("Guest with username: " + usernameGuest + " is logging out");
        if (usernameAdmin != null)
            logger.info("Admin with username: " + usernameAdmin + " is logging out");
        return LOGGED_IN_VIEW.getName();
    }
}
