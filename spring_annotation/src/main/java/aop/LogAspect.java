package aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {
    @Pointcut("execution(* service.impl.*.*(..))")
    public void p() {

    }

    @Before("execution(* service.impl.*.*(..))")
    public void beforeDo(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        System.out.println("before..." + name);
    }

    @After("p()")
    public void AfterDo(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        System.out.println("after..." + name);
    }

    @AfterReturning(value = "p()", returning = "res")
    public void AfterReturn(JoinPoint joinPoint, Object res) {
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        System.out.println("afterReturn..." + name + " res: " + res);
    }

    @AfterThrowing(value = "p()", throwing = "e")
    public void AfterThrowing(JoinPoint joinPoint, Throwable e) {
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        System.out.println("AfterThrowing..." + name + " exception: " + e);
    }

    @Around("p()")
    public Object around(ProceedingJoinPoint joinPoint) {
        Object result = null;
        try {
            System.out.println("----前置");
            result = joinPoint.proceed();
            System.out.println("----返回");
        } catch (Throwable e) {
            System.out.println("----异常");
            e.printStackTrace();
        } finally {
            System.out.println("----后置");
        }
        return result;
    }
}