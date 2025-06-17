package com.udemy.springboot.section03.game;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
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
