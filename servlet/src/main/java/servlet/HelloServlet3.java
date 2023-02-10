package servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;

public class HelloServlet3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String file = "dog.jpeg";
        ServletContext servletContext = this.getServletContext();
        String realPath = servletContext.getRealPath(file);
        FileInputStream fis = new FileInputStream(realPath);
//        resp.setHeader("content-disposition", "attachment;filename=" + file);
        ServletOutputStream os = resp.getOutputStream();
        byte[] buf = new byte[1024];
        while (fis.read(buf) != -1) {
            os.write(buf);
        }
        os.flush();
        fis.close();
    }
}
