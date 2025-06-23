package com.udemy.springbootweb.section07.service;

import com.udemy.springbootweb.section07.bean.Todo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private static List<Todo> todo = new ArrayList<>();

    static {
        todo.add(new Todo(1, "SJ.Lee", "Learn Java", LocalDate.now().plusYears(1), false));
        todo.add(new Todo(2, "SJ.Lee", "Learn Javascript", LocalDate.now().plusYears(2), false));
        todo.add(new Todo(3, "SJ.Lee", "Learn Python", LocalDate.now().plusMonths(18), false));
    }

    public List<Todo> findByUserName() {
        return todo;
    }

    public void addTodo(String description) {
        logger.info("todo: {}", todo.size());
        todo.add(new Todo(todo.size()+1, "SJ.Lee", description, LocalDate.now().plusMonths(11), false));
    }
}
