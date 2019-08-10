package command;

import enums.Mappings;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeCommand extends AbstractCommand{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return Mappings.HOME.getName();
    }
}
