package com.udemy.springboot.section04.lazy;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
class ClassA {

}

@Component
@Lazy
class ClassB {
    private ClassA classA;

    public ClassB(ClassA c) {
        System.out.println("ClassB initialization");
        this.classA = c;
    }

    public void sysout() {
        System.out.println("This is ClassB Function");
    }
}

@ComponentScan
@Configuration
public class LazySpringApplicationConfiguration {
    public static void main(String[] args) {
        try(
                var context = new AnnotationConfigApplicationContext(LazySpringApplicationConfiguration.class)
                ) {
            System.out.println("=================================== initialization End");

            context.getBean(ClassB.class).sysout();
        }
    }
}
