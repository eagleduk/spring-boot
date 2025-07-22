package com.udemy.springbootweb.section17.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LoggingAspect {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    // When
    // execution(* PACKAGE.*.*(..))
    @Before("execution(* com.udemy.springbootweb.section17.aop.*.*.*(..))")
    public void logMethodCall(JoinPoint joinPoint) {
        //What
        logger.info("Call Method = {}", joinPoint);
    }
}
