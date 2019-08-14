package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static enums.Mappings.SUCCESSFUL;

/**
 * Define an object used for executing successful command.
 */
public class SuccessfulCommand implements Command {

    /**
     * Method to execute successful action on HttpServletRequest and HttpServletResponse.
     *
     * @param request  The HttpServletRequest
     * @param response The HttpServletResponse
     * @return The string value representing mapping value.
     * @see enums.Mappings
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return SUCCESSFUL.getName();
    }
}
