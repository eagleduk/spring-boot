package com.udemy.spring.section04.jakarta;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@Component
@Named
class ClassA {
}

//@Component
@Named
class ClassB {

    private ClassA classA;

    public ClassA getClassA() {
        return classA;
    }

//    @Autowired
    @Inject
    public void setClassA(ClassA classA) {
        System.out.println("Auto Setter");
        this.classA = classA;
    }
}

@ComponentScan
@Configuration
public class CDIApplicationConfiguration {
    public static void main(String[] args) {
        try(
                var context = new AnnotationConfigApplicationContext(CDIApplicationConfiguration.class)
                ) {
            System.out.println(context.getBean(ClassB.class).getClassA());
        }
    }
}
