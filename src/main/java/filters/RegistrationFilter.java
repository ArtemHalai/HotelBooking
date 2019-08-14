package filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static enums.Role.ADMIN;
import static enums.Role.GUEST;

/**
 * Define a registration filter class.
 * This class is implementation of Filter.
 *
 * @see Filter
 */
public class RegistrationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {

    }

    /**
     * Method to get session and if session contains any attribute then invalidate this session.
     * Then invoke the next entity in the chain
     * using the FilterChain object
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
            session.invalidate();
        }
        filterChain.doFilter(req, resp);
    }

    @Override
    public void destroy() {

    }
}
