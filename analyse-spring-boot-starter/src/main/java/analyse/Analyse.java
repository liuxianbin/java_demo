package analyse;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Enumeration;

public class Analyse {
    @Autowired
    private AnalyseProperties properties;

    public void deal(HttpServletRequest req) {
        System.out.println("-".repeat(10) + properties.getTitle() + "-".repeat(10));
        String requestURI = req.getRequestURI();
        System.out.println("URL: " + requestURI);
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String k = headerNames.nextElement();
            String v = req.getHeader(k);
            System.out.printf("%s %s\n", k, v);
        }
        System.out.println("-".repeat(20));
    }
}