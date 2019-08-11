package controller.servlets;

import command.Command;
import enums.Mappings;
import factories.CommandFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static enums.Mappings.HOME;
import static enums.Mappings.REGISTRATION_PAGE;

public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(REGISTRATION_PAGE.getName()).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getRequestURI()
                .substring(req.getRequestURI().lastIndexOf("/") + 1);

        Command command = CommandFactory.getCommand(action);

        String page = command.execute(req, resp);

        switch (page) {
            case "errors":
                req.getRequestDispatcher(REGISTRATION_PAGE.getName()).forward(req, resp);
                break;
            case "home":
                resp.sendRedirect(HOME.getName());
                break;
        }
    }
}
