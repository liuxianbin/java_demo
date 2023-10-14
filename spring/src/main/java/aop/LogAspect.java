package aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {

    @Pointcut("execution(void bean.impl.*.*(..))")
    public void p() {

    }

    @Before("p()")
    public void Before(JoinPoint js) {
        System.out.println(js.getSignature().getName());
        System.out.println("------before------");
    }

    @After("p()")
    public void AfterDo(JoinPoint joinPoint) {
        System.out.println("after...");
    }

    @AfterReturning(value = "p()", returning = "res")
    public void AfterReturn(JoinPoint joinPoint, Object res) {
        System.out.println("afterReturn..." + " res: " + res);
    }

    @AfterThrowing(value = "p()", throwing = "e")
    public void AfterThrowing(JoinPoint joinPoint, Throwable e) {
        System.out.println("AfterThrowing..." + " exception: " + e);
    }


    @Around("p()")
    public Object around(ProceedingJoinPoint jp) {
        Object result = null;
        try {
            System.out.println("--前置");
            result = jp.proceed();
            System.out.println("--返回");
        } catch (Throwable e) {
            System.out.println("--异常");
            e.printStackTrace();
        } finally {
            System.out.println("--后置");
        }
        return result;
    }
}
