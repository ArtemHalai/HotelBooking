package filters;

import javax.servlet.*;
import java.io.IOException;

/**
 * Define an request encoding filter class.
 * This class is implementation of Filter.
 *
 * @see Filter
 */
public class EncodingRequestFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {

    }

    /**
     * Method to set character encoding to request.
     * Invoke the next entity in the chain
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
        servletRequest.setCharacterEncoding("UTF-8");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
