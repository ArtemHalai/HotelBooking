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

/**
 * Define logout servlet class which extends HttpServlet class.
 *
 * @see HttpServlet
 */
public class LogoutServlet extends HttpServlet {

    /**
     * This method called by the server to allow a servlet to handle a GET request.
     * Gets session from request and if it has any attribute then invalidates session and redirect to home page.
     *
     * @param req  The HttpServletRequest object.
     * @param resp The HttpServletResponse object.
     * @throws IOException      If IO exception occurred while processing this request.
     * @throws ServletException If servlet exception occurred while processing this request.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute(GUEST.getName()) != null || req.getSession().getAttribute(ADMIN.getName()) != null) {
            HttpSession session = req.getSession(false);
            session.invalidate();
        }
        resp.sendRedirect(HOME.getName());
    }
}
