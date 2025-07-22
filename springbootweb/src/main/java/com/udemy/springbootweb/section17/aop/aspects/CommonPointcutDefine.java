package com.udemy.springbootweb.section17.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class CommonPointcutDefine {

    @Pointcut("execution(* com.udemy.springbootweb.section17.aop.*.*.*(..))")
    public void commonPointcut() {}

    @Pointcut("bean(*Service*)")
    public void commonServicePointcut() {}

    @Pointcut("@annotation(com.udemy.springbootweb.section17.aop.annotations.TrackTime)")
    public void customAnnotation() {}
}
