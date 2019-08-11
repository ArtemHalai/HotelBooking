package controller.servlets.admin_servlets;

import command.Command;
import factories.CommandFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static enums.Mappings.GUESTS_ADMIN_PAGE;
import static enums.Mappings.LOGIN_VIEW;

public class GuestsAdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getRequestURI()
                .substring(req.getRequestURI().lastIndexOf("/") + 1);

        Command command = CommandFactory.getCommand(action);

        String page = command.execute(req, resp);


        switch (page) {
            case "guests_admin":
                req.getRequestDispatcher(GUESTS_ADMIN_PAGE.getName()).forward(req, resp);
                break;
            case "login":
                resp.sendRedirect(LOGIN_VIEW.getName());
                break;
        }
    }
}