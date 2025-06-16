package com.sample.springboot;

import com.sample.springboot.game.GameRunner;
import com.sample.springboot.game.GamingConsole;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.sample.springboot.game")
public class GameLauncherApplication {

    public static void main(String[] args) {

        try(var context = new AnnotationConfigApplicationContext(GameLauncherApplication.class)) {
            context.getBean(GamingConsole.class).up();
            context.getBean(GameRunner.class).run();
        }
    }
}
