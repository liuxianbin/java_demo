package filter;

import javax.servlet.*;
import java.io.IOException;

public class MyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("start filter...");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("end filter...");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("filter init...");
    }

    @Override
    public void destroy() {
        System.out.println("filter destroy...");
    }
}
