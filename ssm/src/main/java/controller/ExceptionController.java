package controller;

import lombok.Data;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {
    @ExceptionHandler
    public R handler(Exception e) {
        System.out.println(e.getMessage());
        R r = new R();
        r.setCode(500);
        r.setMessage(e.getMessage());
        return r;
    }
}

@Data
class R {
    private String message;
    private int code;
}