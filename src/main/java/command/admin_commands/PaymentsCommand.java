package command.admin_commands;

import command.Command;
import exceptions.AccessException;
import facade.admin.PaymentsAdminFacade;
import model.dto.PaymentsAdminDto;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

import static enums.Attributes.*;
import static enums.Errors.NO_PAYMENTS;
import static enums.Mappings.LOGIN_VIEW;
import static enums.Mappings.PAYMENTS_ADMIN;
import static enums.Role.ADMIN;

public class PaymentsCommand implements Command {

    private PaymentsAdminFacade facade = new PaymentsAdminFacade();

    private final Logger logger = Logger.getLogger(this.getClass());

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        if (request.getSession().getAttribute(ADMIN.getName()) != null) {
            int page = 1;
            if (request.getParameter(PAGE.getName()) != null)
                page = Integer.parseInt(request.getParameter(PAGE.getName()));

            PaymentsAdminDto paymentsAdminDto = new PaymentsAdminDto(page, 0, null);

            try {
                paymentsAdminDto = facade.getAllPayments(paymentsAdminDto);
            } catch (SQLException e) {
                logger.error(e.getMessage(), e);
            }

            if (!paymentsAdminDto.getList().isEmpty()) {
                request.setAttribute(PAYMENTS.getName(), paymentsAdminDto.getList());
                request.setAttribute(COUNT.getName(), paymentsAdminDto.getCount());
                request.setAttribute(PAGE.getName(), paymentsAdminDto.getPage());
            } else {
                request.setAttribute(COUNT.getName(), 0);
                request.setAttribute(PAGE.getName(), page);
                request.setAttribute(ERRORS.getName(), NO_PAYMENTS.getName());
            }
            return PAYMENTS_ADMIN.getName();
        }else {
            try {
                throw new AccessException("Someone tried to access admin page with url:"+request.getRequestURI()+" without authentication");
            } catch (AccessException e) {
                logger.error(e.getMessage(), e);
            }
            return LOGIN_VIEW.getName();
        }
    }
}
