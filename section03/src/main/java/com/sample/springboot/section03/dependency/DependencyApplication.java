package com.sample.springboot.section03.dependency;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class Depency1 {

}

@Component
class Depency2 {

}

@Component
class BaseClass {

    /*
            Field Dependency
    @Autowired
    Depency1 depency1;
    @Autowired
    Depency2 depency2;

    public String toString() {
        return "Using " + depency1 + " and " + depency2;
    }
    */

    /*
            Setter-based Dependency
    Depency1 depency1;
    @Autowired
    public void setDepency1(Depency1 depency1) {
        System.out.println("Setter-based: setDepency1");
        this.depency1 = depency1;
    }

    Depency2 depency2;
    @Autowired
    public void setDepency2(Depency2 depency2) {
        System.out.println("Setter-based: setDepency2");
        this.depency2 = depency2;
    }
    */

    /*
            Constructor-based Dependency
     */
    Depency1 depency1;
    Depency2 depency2;

    public BaseClass(Depency1 depency1, Depency2 depency2) {
        System.out.println("Constructor-based BaseClass");
        this.depency1 = depency1;
        this.depency2 = depency2;
    }
}


@Configuration
@ComponentScan
public class DependencyApplication {

    public static void main(String[] args) {

        try(var context = new AnnotationConfigApplicationContext(DependencyApplication.class)) {

            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

            System.out.println(context.getBean(BaseClass.class));
        }
    }
}
