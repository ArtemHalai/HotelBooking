package command.admin_commands;

import command.Command;
import exceptions.AccessException;
import facade.admin.ReservationsAdminFacade;
import model.dto.ReservationsAdminDto;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

import static enums.Attributes.*;
import static enums.Errors.NO_RESERVATIONS;
import static enums.Mappings.LOGIN_VIEW;
import static enums.Mappings.RESERVATIONS_ADMIN;
import static enums.Role.ADMIN;

/**
 * Define an object used for executing reservations command on ReservationsCommand.
 *
 * @see ReservationsCommand
 */
public class ReservationsCommand implements Command {

    private ReservationsAdminFacade facade = new ReservationsAdminFacade();
    private final Logger logger = Logger.getLogger(this.getClass());

    /**
     * Method to execute reservations actions on HttpServletRequest and HttpServletResponse.
     *
     * @param request  The HttpServletRequest
     * @param response The HttpServletResponse
     * @return The string value representing mapping value.
     * @see enums.Mappings
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        if (request.getSession().getAttribute(ADMIN.getName()) != null) {
            int page = 1;
            if (request.getParameter(PAGE.getName()) != null)
                page = Integer.parseInt(request.getParameter(PAGE.getName()));

            ReservationsAdminDto reservationsAdminDto = new ReservationsAdminDto(page, 0, null);

            try {
                reservationsAdminDto = facade.getAllReservations(reservationsAdminDto);
            } catch (SQLException e) {
                logger.error(e.getMessage(), e);
            }

            if (!reservationsAdminDto.getList().isEmpty()) {
                request.setAttribute(RESERVATIONS.getName(), reservationsAdminDto.getList());
                request.setAttribute(COUNT.getName(), reservationsAdminDto.getCount());
                request.setAttribute(PAGE.getName(), reservationsAdminDto.getPage());
            } else {
                request.setAttribute(COUNT.getName(), 0);
                request.setAttribute(PAGE.getName(), page);
                request.setAttribute(ERRORS.getName(), NO_RESERVATIONS.getName());
            }
            return RESERVATIONS_ADMIN.getName();
        } else {
            try {
                throw new AccessException("Someone tried to access admin page with url:" + request.getRequestURI() + " without authentication");
            } catch (AccessException e) {
                logger.error(e.getMessage(), e);
            }
            return LOGIN_VIEW.getName();
        }
    }
}
