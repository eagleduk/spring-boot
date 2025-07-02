package com.udemy.springbootweb.section08.bean;

public class Version2 {
    private Name name;

    public Version2(Name name) {
        this.name = name;
    }

    public Name getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Version2{" +
                "name=" + name +
                '}';
    }


}
