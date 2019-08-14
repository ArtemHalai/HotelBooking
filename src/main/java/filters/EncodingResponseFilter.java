package filters;

import javax.servlet.*;
import java.io.IOException;

/**
 * Define an response encoding filter class.
 * This class is implementation of Filter.
 *
 * @see Filter
 */
public class EncodingResponseFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {

    }

    /**
     * Method to set character encoding to response.
     * Invoke the next entity in the chain
     * using the FilterChain object
     * (<code>chain.doFilter()</code>).
     *
     * @param req  The ServletRequest object.
     * @param resp The ServletResponse object.
     * @param chain     The FilterChain object.
     * @throws IOException      If IO exception occurred while processing this request.
     * @throws ServletException If servlet exception occurred while processing this request.
     */
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        chain.doFilter(req, resp);
    }

    @Override
    public void destroy() {

    }

}
