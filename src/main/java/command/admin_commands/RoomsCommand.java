package command.admin_commands;

import command.AbstractCommand;
import enums.Mappings;
import facade.admin.RoomsAdminFacade;
import model.dto.RoomsAdminDto;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

import static enums.Attributes.*;
import static enums.Errors.NO_ROOMS;
import static enums.Mappings.ROOMS_ADMIN;
import static enums.Role.ADMIN;

public class RoomsCommand extends AbstractCommand {
    private RoomsAdminFacade facade = new RoomsAdminFacade();

    private final Logger logger = Logger.getLogger(this.getClass());

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        if (request.getSession().getAttribute(ADMIN.getName()) != null) {
            int page = 1;
            if (request.getParameter(PAGE.getName()) != null)
                page = Integer.parseInt(request.getParameter(PAGE.getName()));

            RoomsAdminDto roomsAdminDto = new RoomsAdminDto(page, 0, null);

            try {
                roomsAdminDto = facade.getAllRooms(roomsAdminDto);
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }

            if (!roomsAdminDto.getList().isEmpty()) {
                request.setAttribute(ROOMS.getName(), roomsAdminDto.getList());
                request.setAttribute(COUNT.getName(), roomsAdminDto.getCount());
                request.setAttribute(PAGE.getName(), roomsAdminDto.getPage());
            } else {
                request.setAttribute(COUNT.getName(), 0);
                request.setAttribute(PAGE.getName(), page);
                request.setAttribute(ERRORS.getName(), NO_ROOMS.getName());
            }
            return ROOMS_ADMIN.getName();
        } else {
            logger.info("Someone tried to see admin page with url:" + request.getRequestURI() + " without authentication");
            return Mappings.LOGIN_VIEW.getName();
        }
    }
}
