package filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static enums.Mappings.LOGGED_IN_VIEW;
import static enums.Role.ADMIN;
import static enums.Role.GUEST;

/**
 * Define a login filter class.
 * This class is implementation of Filter.
 *
 * @see Filter
 */
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {
    }

    /**
     * Method to get session and if session contains any attribute then redirect user to logged view page and ask if
     * user wants to logout.
     * Or invoke the next entity in the chain
     * using the FilterChain object otherwise
     * (<code>filterChain.doFilter()</code>).
     *
     * @param servletRequest  The ServletRequest object.
     * @param servletResponse The ServletResponse object.
     * @param filterChain     The FilterChain object.
     * @throws IOException      If IO exception occurred while processing this request.
     * @throws ServletException If servlet exception occurred while processing this request.
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        HttpSession session = req.getSession(false);

        if (session.getAttribute(GUEST.getName()) != null || session.getAttribute(ADMIN.getName()) != null) {
            resp.sendRedirect(LOGGED_IN_VIEW.getName());
        } else {
            filterChain.doFilter(req, resp);
        }
    }

    @Override
    public void destroy() {

    }
}
