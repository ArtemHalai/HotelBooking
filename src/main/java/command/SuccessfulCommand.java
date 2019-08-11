package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static enums.Mappings.SUCCESSFUL;

public class SuccessfulCommand implements Command  {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return SUCCESSFUL.getName();
    }
}
