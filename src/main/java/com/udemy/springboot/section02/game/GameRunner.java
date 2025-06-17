package com.udemy.springboot.section02.game;

public class GameRunner {

//    private MarioGame game;
    private GamingConsole game;

    public GameRunner(GamingConsole g) {
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
