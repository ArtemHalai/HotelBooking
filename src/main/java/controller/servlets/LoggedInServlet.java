package controller.servlets;

import command.Command;
import factories.CommandFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static enums.Mappings.LOGGED_IN;

/**
 * Define logged in servlet class which extends HttpServlet class.
 *
 * @see HttpServlet
 */
public class LoggedInServlet extends HttpServlet {

    /**
     * This method called by the server to allow a servlet to handle a GET request.
     * Gets request URI and delegate action to CommandFactory to define which command to use for this request.
     * Then execute command and define what to do further.
     *
     * @param req  The HttpServletRequest object.
     * @param resp The HttpServletResponse object.
     * @throws IOException      If IO exception occurred while processing this request.
     * @throws ServletException If servlet exception occurred while processing this request.
     * @see CommandFactory
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getRequestURI()
                .substring(req.getRequestURI().lastIndexOf("/") + 1);

        Command command = CommandFactory.getCommand(action);

        String page = command.execute(req, resp);

        switch (page) {
            case "logged_in":
                req.getRequestDispatcher(LOGGED_IN.getName()).forward(req, resp);
                break;
        }
    }
}
