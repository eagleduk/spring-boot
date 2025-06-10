package com.sample.springboot;

import com.sample.springboot.game.GameRunner;
import com.sample.springboot.game.MarioGame;
import com.sample.springboot.game.SuperGontraGame;

public class AppGamingBasicJava {

    public static void main(String[] args) {

        // var game = new MarioGame();
        var game = new SuperGontraGame();
        var gameRunner = new GameRunner(game);
        gameRunner.run();
    }
}
