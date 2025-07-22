package com.udemy.springbootweb.section17.aop.aspects;

// Weaver
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
// Aspect - Pointcut + Advice
@Aspect
public class LoggingAspect {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    // Pointcut - When
    // execution(* PACKAGE.*.*(..))
    @Before("com.udemy.springbootweb.section17.aop.aspects.CommonPointcutDefine.commonPointcut()")
    public void logBeforeMethodCall(/* Join Point */JoinPoint joinPoint) {

        // Advice - What
        logger.info("Before Call Method = {} needs arguments: {}", joinPoint, joinPoint.getArgs());
    }

    @After("execution(* com.udemy.springbootweb.section17.aop.*.*.*(..))")
    public void logAfterMethodCall(JoinPoint joinPoint) {

        logger.info("Call After Method = {} needs arguments: {}", joinPoint, joinPoint.getArgs());
    }

    @AfterThrowing(
            pointcut = "execution(* com.udemy.springbootweb.section17.aop.*.*.*(..))",
            throwing = "exception"
    )
    public void logMethodExceptionCall(JoinPoint joinPoint, Exception exception) {

        logger.info("Call Method = {} thrown exception: {}", joinPoint, exception.getLocalizedMessage());
    }

    @AfterReturning(
            pointcut = "execution(* com.udemy.springbootweb.section17.aop.*.*.*(..))",
            returning = "returnObject"
    )
    public void logMethodSuccessCall(JoinPoint joinPoint, Object returnObject) {

        logger.info("Call Method = {} return: {}", joinPoint, returnObject);
    }

}
