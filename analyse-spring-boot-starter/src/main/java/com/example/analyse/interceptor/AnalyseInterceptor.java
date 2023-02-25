package com.example.analyse.interceptor;

import com.example.analyse.Analyse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AnalyseInterceptor implements HandlerInterceptor {
    @Autowired
    private Analyse analyse;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        System.out.println("拦截器 " + uri);
        analyse.print();
        return true;
    }
}
