package command;

import enums.Mappings;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static enums.Mappings.HOME;

public class HomeCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return HOME.getName();
    }
}
