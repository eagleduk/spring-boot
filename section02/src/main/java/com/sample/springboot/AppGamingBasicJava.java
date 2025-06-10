package com.sample.springboot;

import com.sample.springboot.game.GameRunner;
import com.sample.springboot.game.MarioGame;
import com.sample.springboot.game.SuperGontraGame;

public class AppGamingBasicJava {

    public static void main(String[] args) {

        var marioGame = new MarioGame();
        var superContra = new SuperGontraGame();
        var gameRunner = new GameRunner(superContra);
        gameRunner.run();
    }
}
