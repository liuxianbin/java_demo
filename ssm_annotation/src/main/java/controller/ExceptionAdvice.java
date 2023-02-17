package controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvice {
    @ExceptionHandler(Exception.class)
    public String doException(Exception e) {
        System.out.println("deal exception" + e.getMessage());
        return "deal";
    }
}
