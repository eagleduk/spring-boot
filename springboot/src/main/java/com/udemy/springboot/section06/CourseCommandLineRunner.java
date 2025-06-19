package com.udemy.springboot.section06;

import com.udemy.springboot.section06.course.Course;
import com.udemy.springboot.section06.jpa.JpaRepository;
import com.udemy.springboot.section06.springdatajpa.SpringDataJpaRepository;
import com.udemy.springboot.section06.springjdbc.SpringJdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

//    @Autowired
//    private SpringJdbcRepository repository;

//    @Autowired
//    private JpaRepository repository;

    @Autowired
    private SpringDataJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Course(1, "Learn Java Spring Data JPA", "SJ.LEE"));
        repository.save(new Course(2, "Learn Javascript Spring Data JPA", "SJ.LEE"));
        repository.save(new Course(3, "Learn Python Spring Data JPA", "SJ.LEE"));

        repository.deleteById(1L);

        System.out.println("findById: " + repository.findById(2L));
        System.out.println("findById: " + repository.findById(3L));

        System.out.println("findByName: " + repository.findByName("Learn Python Spring Data JPA"));
        System.out.println("findByAuthor: " + repository.findByAuthor("SJ.LEE"));
    }
}
