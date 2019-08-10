package controller.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static enums.Mappings.HOME;
import static enums.Role.ADMIN;
import static enums.Role.GUEST;

public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute(GUEST.getName()) != null || req.getSession().getAttribute(ADMIN.getName()) != null) {
            HttpSession session = req.getSession(false);
            session.invalidate();
        }
        resp.sendRedirect(HOME.getName());
    }
}
