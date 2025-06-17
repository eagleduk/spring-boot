package com.udemy.springboot.section02.helloworld;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class AppHelloWorldSpring {

    public static void main(String[] args) {

        // 1: Launch a Spring Context
        try(var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class)) {

            // 2: Configure the things that we want Spring to manage
            // HelloWorldConfiguration - @Configuration
            // name - @Bean

            // 3: Retrieving Beans managed by Spring
            System.out.println(context.getBean("name"));
            System.out.println(context.getBean("age"));
            System.out.println(context.getBean("person"));
            System.out.println(context.getBean("personMethod"));
            System.out.println(context.getBean("personParameter"));
            System.out.println(context.getBean("personQualifier"));
            System.out.println(context.getBean("address2"));

            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

            System.out.println(context.getBean(Address.class));

        }

    }
}
