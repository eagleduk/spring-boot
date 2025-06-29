package com.udemy.spring.section03.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {

//    private MarioGame game;
    private GamingConsole game;


    public GameRunner(@Qualifier("marioGame") GamingConsole g) {
        this.game = g;
    }

    public void run() {
        System.out.println("Running Game: " + this.game);
        game.up();
        game.down();
        game.right();
        game.left();
    }
}
