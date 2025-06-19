package com.udemy.springboot.section06;

import com.udemy.springboot.section06.course.Course;
import com.udemy.springboot.section06.springjdbc.SpringJdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

    @Autowired
    private SpringJdbcRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.insert(new Course(1, "Learn Java", "SJ.LEE"));
        repository.insert(new Course(2, "Learn Javascript", "SJ.LEE"));
        repository.insert(new Course(3, "Learn Python", "SJ.LEE"));

        repository.deleteById(1);

        Course c2 = repository.findById(2);
        Course c3 = repository.findById(3);

        System.out.println("id: " + c2.getId() + ", name: " + c2.getName() + ", author: " + c2.getAuthor());
        System.out.println("id: " + c3.getId() + ", name: " + c3.getName() + ", author: " + c3.getAuthor());
    }
}
