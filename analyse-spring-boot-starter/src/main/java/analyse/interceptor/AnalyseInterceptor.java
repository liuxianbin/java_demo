package analyse.interceptor;

import analyse.Analyse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

public class AnalyseInterceptor implements HandlerInterceptor {
    @Autowired
    private Analyse analyse;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        analyse.deal(request);
        return true;
    }
}