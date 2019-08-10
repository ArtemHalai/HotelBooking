package controller.servlets;

import enums.Mappings;
import enums.Role;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute(Role.ADMIN.toString()) != null) {
            resp.sendRedirect(Mappings.HOME_ADMIN.getName());
        } else {
            req.getRequestDispatcher(Mappings.INDEX_PAGE.getName()).forward(req, resp);
        }
    }
}
