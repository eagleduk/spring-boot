package com.udemy.springboot.section05;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController {

    @RequestMapping("/course")
    public List<Curse> retrieveAllCurse() {
        return Arrays.asList(
                new Curse(1, "Python", "SJ.Lee"),
                new Curse(2, "Javascript", "SJ.Lee"),
                new Curse(3, "Java", "SJ.Lee"),
                new Curse(4, "Typescript", "SJ.Lee"),
                new Curse(5, "React", "SJ.Lee")
        );
    }
}
