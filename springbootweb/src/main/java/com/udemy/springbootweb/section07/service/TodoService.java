package com.udemy.springbootweb.section07.service;

import com.udemy.springbootweb.section07.bean.Todo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {

    private static List<Todo> todo = new ArrayList<>();

    static {
        todo.add(new Todo(1, "SJ.Lee", "Learn Java", LocalDate.now().plusYears(1), false));
        todo.add(new Todo(2, "SJ.Lee", "Learn Javascript", LocalDate.now().plusYears(2), false));
        todo.add(new Todo(3, "SJ.Lee", "Learn Python", LocalDate.now().plusMonths(18), false));
    }

    public List<Todo> findByUserName() {
        return todo;
    }
}
