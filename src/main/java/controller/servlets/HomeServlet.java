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

/**
 * Define home servlet class which extends HttpServlet class.
 *
 * @see HttpServlet
 */
public class HomeServlet extends HttpServlet {

    /**
     * This method called by the server to allow a servlet to handle a GET request.
     * Gets session from request and if session contains attribute with user in ADMIN role then redirect admin to
     * home admin page or forward request and response to index page.
     *
     * @param req  The HttpServletRequest object.
     * @param resp The HttpServletResponse object.
     * @throws IOException      If IO exception occurred while processing this request.
     * @throws ServletException If servlet exception occurred while processing this request.
     */
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
