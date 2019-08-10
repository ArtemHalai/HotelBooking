package command.admin_commands;

import command.AbstractCommand;
import facade.admin.GuestsAdminFacade;
import model.dto.GuestsAdminDto;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

import static enums.Attributes.*;
import static enums.Errors.NO_GUESTS;
import static enums.Mappings.GUESTS_ADMIN;
import static enums.Mappings.LOGIN_VIEW;
import static enums.Role.ADMIN;

public class GuestsCommand extends AbstractCommand {

    private GuestsAdminFacade facade = new GuestsAdminFacade();

    private final Logger logger = Logger.getLogger(this.getClass());

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        if (request.getSession().getAttribute(ADMIN.getName()) != null) {
            int page = 1;
            if (request.getParameter(PAGE.getName()) != null)
                page = Integer.parseInt(request.getParameter(PAGE.getName()));

            GuestsAdminDto guestsAdminDto = new GuestsAdminDto(page, 0, null);

            try {
                guestsAdminDto = facade.getAllGuests(guestsAdminDto);
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }

            if (!guestsAdminDto.getList().isEmpty()) {
                request.setAttribute(GUESTS.getName(), guestsAdminDto.getList());
                request.setAttribute(COUNT.getName(), guestsAdminDto.getCount());
                request.setAttribute(PAGE.getName(), guestsAdminDto.getPage());
            } else {
                request.setAttribute(COUNT.getName(), 0);
                request.setAttribute(PAGE.getName(), page);
                request.setAttribute(ERRORS.getName(), NO_GUESTS.getName());
            }
            return GUESTS_ADMIN.getName();
        }else {
            logger.info("Someone tried to see admin page with url:"+request.getRequestURI()+" without authentication");
            return LOGIN_VIEW.getName();
        }
    }
}
