package filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

@WebFilter("/*")
public class LogFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("----------start-----------");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("----------end-----------");
    }

    @Override
    public void destroy() {
        System.out.println("LogFilter destroy...");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("LogFilter init...");
    }
}
