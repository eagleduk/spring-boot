package com.udemy.spring.section04.xml;

import com.udemy.spring.section02.game.GameRunner;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class XMLApplicationConfiguration {
    public static void main(String[] args) {
        try(
                var context = new ClassPathXmlApplicationContext("contextConfiguration.xml")
                ) {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

            System.out.println(context.getBean("name"));
            System.out.println(context.getBean("age"));

            context.getBean(GameRunner.class).run();
        }
    }
}
