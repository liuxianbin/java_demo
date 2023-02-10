package servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class HelloServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getContextPath());
        System.out.println(req.getServletPath());
        System.out.println(req.getMethod());
        System.out.println(req.getPathInfo());
        System.out.println(req.getQueryString());
        System.out.println(req.getRequestURI());
        System.out.println(req.getRequestURL());
        System.out.println(req.getScheme());
        System.out.println(req.getRemoteAddr());
        System.out.println(req.getProtocol());
        System.out.println("###############");
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            String content = req.getHeader(name);
            System.out.println(name + ": " + content);
        }
    }
}
