package com.udemy.springboot.section06.course;

public class Course {

    private long id;
    private String name;
    private String author;

    public Course() {}
    public Course(long i, String n, String a) {
        this.id = i;
        this.name = n;
        this.author = a;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }


}
