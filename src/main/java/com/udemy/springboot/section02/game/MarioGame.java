package com.udemy.springboot.section02.game;

public class MarioGame implements GamingConsole {

    public void up() {
        System.out.println("Jump");
    }
    public void down() {
        System.out.println("Into the hole");
    }
    public void right() {
        System.out.println("Go forward");
    }
    public void left() {
        System.out.println("Go Back");
    }
}
