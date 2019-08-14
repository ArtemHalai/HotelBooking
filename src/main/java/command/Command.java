package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Define an object used for executing command.
 */
public interface Command {

    /**
     * Method to execute necessary actions on HttpServletRequest and HttpServletResponse.
     *
     * @param request  The HttpServletRequest
     * @param response The HttpServletResponse
     * @return The string value representing mapping value.
     * @see enums.Mappings
     */
    String execute(HttpServletRequest request, HttpServletResponse response);
}
