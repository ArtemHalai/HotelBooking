package command.admin_commands;

import command.AbstractCommand;
import facade.admin.RoomRequestsAdminFacade;
import model.dto.RoomRequestsAdminDto;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

import static enums.Attributes.*;
import static enums.Errors.NO_ROOM_REQUESTS;
import static enums.Mappings.LOGIN_VIEW;
import static enums.Mappings.ROOM_REQUESTS_ADMIN;
import static enums.Role.ADMIN;

public class RoomRequestsCommand extends AbstractCommand {

    private RoomRequestsAdminFacade facade = new RoomRequestsAdminFacade();

    private final Logger logger = Logger.getLogger(this.getClass());

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        if (request.getSession().getAttribute(ADMIN.getName()) != null) {
            int page = 1;
            if (request.getParameter(PAGE.getName()) != null)
                page = Integer.parseInt(request.getParameter(PAGE.getName()));

            RoomRequestsAdminDto roomRequestsAdminDto = new RoomRequestsAdminDto(page, 0, null);

            try {
                roomRequestsAdminDto = facade.getAllRoomRequests(roomRequestsAdminDto);
            } catch (SQLException e) {
               logger.error(e.getMessage());
            }

            if (!roomRequestsAdminDto.getList().isEmpty()) {
                request.setAttribute(ROOM_REQUESTS.getName(), roomRequestsAdminDto.getList());
                request.setAttribute(COUNT.getName(), roomRequestsAdminDto.getCount());
                request.setAttribute(PAGE.getName(), roomRequestsAdminDto.getPage());
            } else {
                request.setAttribute(COUNT.getName(), 0);
                request.setAttribute(PAGE.getName(), page);
                request.setAttribute(ERRORS.getName(), NO_ROOM_REQUESTS.getName());
            }
            return ROOM_REQUESTS_ADMIN.getName();
        } else {
            logger.info("Someone tried to see admin page with url:"+request.getRequestURI()+" without authentication");
            return LOGIN_VIEW.getName();
        }
    }
}
