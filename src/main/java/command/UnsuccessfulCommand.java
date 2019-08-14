package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static enums.Mappings.UNSUCCESSFUL;

/**
 * Define an object used for executing unsuccessful command.
 */
public class UnsuccessfulCommand implements Command {

    /**
     * Method to execute unsuccessful action on HttpServletRequest and HttpServletResponse.
     *
     * @param request  The HttpServletRequest
     * @param response The HttpServletResponse
     * @return The string value representing mapping value.
     * @see enums.Mappings
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return UNSUCCESSFUL.getName();
    }
}
