package com.sample.springboot;

import com.sample.springboot.game.GameRunner;
import com.sample.springboot.game.GamingConsole;
import com.sample.springboot.game.MarioGame;
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
