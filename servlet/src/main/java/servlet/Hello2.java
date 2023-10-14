package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;

@WebServlet("/hello2")
public class Hello2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        display(req);
        String path = req.getServletContext().getRealPath("dog.jpeg");
        InputStream is = new FileInputStream(path);
        OutputStream os = resp.getOutputStream();
        int len;
        byte[] buf = new byte[1024];
        while ((len = is.read(buf)) != -1) {
            os.write(buf, 0, len);
        }
        os.flush();
        os.close();
        is.close();
    }

    public void display(HttpServletRequest req) {
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
            String s = headerNames.nextElement();
            System.out.println(s + "=" + req.getHeader(s));
        }
        System.out.println("###############");
    }
}
