package com.udemy.springboot.section02;

import com.udemy.springboot.section02.game.GameRunner;
import com.udemy.springboot.section02.game.GamingConsole;
import com.udemy.springboot.section02.game.MarioGame;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppGameConfiguration {

    @Bean
    public GamingConsole game() {
        return new MarioGame();
    }

    @Bean
    public GameRunner gameRunner(GamingConsole game) {
        return new GameRunner(game);
    }
}
