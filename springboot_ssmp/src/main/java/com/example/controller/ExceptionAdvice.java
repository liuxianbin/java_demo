package com.example.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvice {
    @ExceptionHandler
    public String doException(Exception e) {
        System.out.println("deal exception" + e.getMessage());
        return "deal";
    }
}
