package com.udemy.springbootweb.section08.bean;

public class Version1 {
    private String name;

    public Version1(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Version1{" +
                "name='" + name + '\'' +
                '}';
    }
}
