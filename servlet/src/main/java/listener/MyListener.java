package listener;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class MyListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        System.out.println("lang: " + context.getInitParameter("lang"));
        ServletContextListener.super.contextInitialized(sce);
        System.out.println("MyListener destroy");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("MyListener destroy");
        ServletContextListener.super.contextDestroyed(sce);
    }
}
