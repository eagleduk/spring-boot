package com.udemy.springboot.section06.springdatajpa;

import com.udemy.springboot.section06.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpringDataJpaRepository extends JpaRepository<Course, Long> {

    List<Course> findByName(String name);
    List<Course> findByAuthor(String author);
}
