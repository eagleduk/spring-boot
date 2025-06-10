package com.sample.springboot.game;

public class GameRunner {

//    private MarioGame game;
    private SuperGontraGame game;

    public GameRunner(SuperGontraGame g) {
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
