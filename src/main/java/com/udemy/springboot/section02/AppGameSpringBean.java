package com.udemy.springboot.section02;

import com.udemy.springboot.section02.game.GameRunner;
import com.udemy.springboot.section02.game.GamingConsole;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppGameSpringBean {

    public static void main(String[] args) {

        try(var context = new AnnotationConfigApplicationContext(AppGameConfiguration.class)) {
            context.getBean(GamingConsole.class).up();
            context.getBean(GameRunner.class).run();
        }
    }
}
