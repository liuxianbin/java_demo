package listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class Mylistener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        String lang = servletContext.getInitParameter("lang");
        System.out.println("listener init..." + " lang: " + lang);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("listener destroy...");
        ServletContextListener.super.contextDestroyed(sce);
    }
}
