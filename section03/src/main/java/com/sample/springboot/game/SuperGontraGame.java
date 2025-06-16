package com.sample.springboot.game;

public class SuperGontraGame implements GamingConsole {
    public void up() {
        System.out.println("Jump");
    }
    public void down() {
        System.out.println("Sit down");
    }
    public void right() {
        System.out.println("Go left");
    }
    public void left() {
        System.out.println("Fire bullet");
    }
}
