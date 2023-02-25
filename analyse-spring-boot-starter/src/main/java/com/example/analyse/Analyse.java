package com.example.analyse;

import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class Analyse {
    @Autowired
    private AnalyseProperties properties;

    public void print() {
        String fmt = "%s--%s--拦截器";
        System.out.printf((fmt) + "%n", LocalDateTime.now(), properties.getTitle());
    }

    public void print2() {
        System.out.printf("%s--%s--手动 %n", LocalDateTime.now(), properties.getTitle());
    }
}
