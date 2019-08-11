package controller.servlets;
import enums.Role;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static enums.Mappings.HOME_ADMIN;
import static enums.Mappings.INDEX_PAGE;

public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute(Role.ADMIN.getName()) != null) {
            resp.sendRedirect(HOME_ADMIN.getName());
        } else {
            req.getRequestDispatcher(INDEX_PAGE.getName()).forward(req, resp);
        }
    }
}