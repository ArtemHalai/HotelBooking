package controller.servlets;

import command.Command;
import enums.Role;
import factories.CommandFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static enums.Mappings.*;

/**
 * Define payment servlet class which extends HttpServlet class.
 *
 * @see HttpServlet
 */
public class PaymentServlet extends HttpServlet {

    /**
     * This method called by the server to allow a servlet to handle a GET request.
     * Gets session from request and if it doesn't contain attribute with user in role GUEST then redirect to
     * login page.
     *
     * @param req  The HttpServletRequest object.
     * @param resp The HttpServletResponse object.
     * @throws IOException      If IO exception occurred while processing this request.
     * @throws ServletException If servlet exception occurred while processing this request.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute(Role.GUEST.getName()) == null)
            resp.sendRedirect(LOGIN_VIEW_PATH.getName());
        else
            req.getRequestDispatcher(PAYMENT_PAGE.getName()).forward(req, resp);

    }

    /**
     * This method called by the server to allow a servlet to handle a POST request.
     * Gets request URI and delegate action to CommandFactory to define which command to use for this request.
     * Then execute command and define what to do further.
     *
     * @param req  The HttpServletRequest object.
     * @param resp The HttpServletResponse object.
     * @throws IOException If IO exception occurred while processing this request.
     * @see CommandFactory
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String action = req.getRequestURI()
                .substring(req.getRequestURI().lastIndexOf("/") + 1);

        Command command = CommandFactory.getCommand(action);

        String page = command.execute(req, resp);

        switch (page) {
            case "errors":
                resp.sendRedirect(req.getServletPath());
                break;
            case "successful":
                resp.sendRedirect(req.getServletPath() + "/" + SUCCESSFUL.getName());
                break;
            case "unsuccessful":
                resp.sendRedirect(req.getServletPath() + "/" + UNSUCCESSFUL.getName());
                break;
        }
    }
}
