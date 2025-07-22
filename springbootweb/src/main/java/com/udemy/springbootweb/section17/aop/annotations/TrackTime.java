package com.udemy.springbootweb.section17.aop.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//What
@Target(ElementType.METHOD)
//When
@Retention(RetentionPolicy.RUNTIME)
public @interface TrackTime {

}
