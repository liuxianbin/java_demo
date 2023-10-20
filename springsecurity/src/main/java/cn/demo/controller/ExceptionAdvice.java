package cn.demo.controller;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ExceptionAdvice {
    @ExceptionHandler(Exception.class)
    public String doException(Exception e) {
        return "全局捕获异常" + e.getMessage();
    }

    @ExceptionHandler(AccessDeniedException.class)
    public String doException(AccessDeniedException e) {
        //因为AccessDeniedException及子类和认证异常AuthenticationException及子类都会优先被全局异常执行
        //执行顺序如下：Controller >> Aspect >> ControllerAdvice >> Interceptor >> Filter
        //想让Security自己处理的话，直接抛出
        throw e;
    }
}
