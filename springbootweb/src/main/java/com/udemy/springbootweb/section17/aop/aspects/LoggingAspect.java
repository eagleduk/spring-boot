package com.udemy.springbootweb.section17.aop.aspects;

// Weaver
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

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
    @Before("execution(* com.udemy.springbootweb.section17.aop.*.*.*(..))")
    public void logMethodCall(/* Join Point */JoinPoint joinPoint) {

        // Advice - What
        logger.info("Call Method = {} needs arguments: {}", joinPoint, joinPoint.getArgs());
    }
}
