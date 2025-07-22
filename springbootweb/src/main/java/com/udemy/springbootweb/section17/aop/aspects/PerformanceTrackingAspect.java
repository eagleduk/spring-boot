package com.udemy.springbootweb.section17.aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class PerformanceTrackingAspect {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Around("execution(* com.udemy.springbootweb.section17.aop.*.*.*(..))")
    public Object trackingLogger(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startMillis = System.currentTimeMillis();

        Object proceed = proceedingJoinPoint.proceed();

        long endMillis = System.currentTimeMillis();

        logger.info("execute method: {}, duration time {}ms", proceedingJoinPoint, endMillis - startMillis);

        return proceed;
    }

    @Around("com.udemy.springbootweb.section17.aop.aspects.CommonPointcutDefine.customAnnotation()")
    public Object trackingCustomAnnotationLogger(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startMillis = System.currentTimeMillis();

        Object proceed = proceedingJoinPoint.proceed();

        long endMillis = System.currentTimeMillis();

        logger.info("Custom Annotation execute method: {}, duration time {}ms", proceedingJoinPoint, endMillis - startMillis);

        return proceed;
    }
}
