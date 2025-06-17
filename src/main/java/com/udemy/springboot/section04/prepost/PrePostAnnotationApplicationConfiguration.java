package com.udemy.springboot.section04.prepost;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
class ClassA {
    public void init() {
        System.out.println("Class A Logic Run");
    }
}

@Component
class ClassB {
    private ClassA classA;

    public ClassB(ClassA c) {
        System.out.println("ClassB initialization");
        this.classA = c;
    }

    @PreDestroy
    public void pre() {
        System.out.println("clean up");
    }

    @PostConstruct
    public void post() {
        this.classA.init();
    }
}

@ComponentScan
@Configuration
public class PrePostAnnotationApplicationConfiguration {
    public static void main(String[] args) {
        try(
                var context = new AnnotationConfigApplicationContext(PrePostAnnotationApplicationConfiguration.class)
                ) {
            context.getBean(ClassB.class);
        }
    }
}
