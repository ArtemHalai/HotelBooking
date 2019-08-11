package command.admin_commands;

import command.Command;
import exceptions.AccessException;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static enums.Mappings.HOME_ADMIN;
import static enums.Mappings.LOGIN_VIEW;
import static enums.Role.ADMIN;

public class HomeAdminCommand implements Command {

    private final Logger logger = Logger.getLogger(this.getClass());
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        if (request.getSession().getAttribute(ADMIN.getName()) != null) {
            return HOME_ADMIN.getName();
        } else {
            try {
                throw new AccessException("Someone tried to access admin page with url:"+request.getRequestURI()+" without authentication");
            } catch (AccessException e) {
                logger.error(e.getMessage(), e);
            }
            return LOGIN_VIEW.getName();
        }
    }
}
