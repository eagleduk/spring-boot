package com.udemy.springbootweb.section07.service;

import com.udemy.springbootweb.section07.bean.Todo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private static List<Todo> todo = new ArrayList<>();

    private static int id = 1;

    static {
        todo.add(new Todo(id++, "SJ.Lee", "Learn Java", LocalDate.now().plusYears(1), false));
        todo.add(new Todo(id++, "SJ.Lee", "Learn Javascript", LocalDate.now().plusYears(2), false));
        todo.add(new Todo(id++, "SJ.Lee", "Learn Python", LocalDate.now().plusMonths(18), false));
    }

    public List<Todo> findByUserName() {
        return todo;
    }

    public void addTodo(String username, String description, LocalDate targetDate, boolean done) {
        logger.info("todo: {}", todo.size());
        todo.add(new Todo(id++, username, description, targetDate, done));
    }

    public void removeById(int i) {

        Predicate<? super Todo> predicate = todo -> todo.getId() == i;

        todo.removeIf(predicate);
    }
}
