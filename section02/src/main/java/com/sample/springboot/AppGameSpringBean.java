package com.sample.springboot;

import com.sample.springboot.game.GameRunner;
import com.sample.springboot.game.GamingConsole;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppGameSpringBean {

    public static void main(String[] args) {

        try(var context = new AnnotationConfigApplicationContext(AppGameConfiguration.class)) {
            context.getBean(GamingConsole.class).up();
            context.getBean(GameRunner.class).run();
        }
    }
}
