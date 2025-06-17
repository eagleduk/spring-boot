package com.udemy.springboot.section04.scope;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
class ClassA {

}

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class ClassB {
}

@ComponentScan
@Configuration
public class ScopeApplicationConfiguration {
    public static void main(String[] args) {
        try(
                var context = new AnnotationConfigApplicationContext(ScopeApplicationConfiguration.class)
                ) {

            System.out.println(context.getBean(ClassA.class));
            System.out.println(context.getBean(ClassA.class));
            System.out.println(context.getBean(ClassA.class));
            System.out.println(context.getBean(ClassA.class));

            System.out.println(context.getBean(ClassB.class));
            System.out.println(context.getBean(ClassB.class));
            System.out.println(context.getBean(ClassB.class));
            System.out.println(context.getBean(ClassB.class));
            System.out.println(context.getBean(ClassB.class));
        }
    }
}
