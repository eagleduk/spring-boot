package com.udemy.springboot.section02;

import com.udemy.springboot.section02.game.GameRunner;
import com.udemy.springboot.section02.game.SuperGontraGame;

public class AppGamingBasicJava {

    public static void main(String[] args) {

        // var game = new MarioGame();
        var game = new SuperGontraGame();
        var gameRunner = new GameRunner(game);
        gameRunner.run();
    }
}
