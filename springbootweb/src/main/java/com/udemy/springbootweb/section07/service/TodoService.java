package com.udemy.springbootweb.section07.service;

import com.udemy.springbootweb.section07.bean.Todo;
import com.udemy.springbootweb.section07.repository.TodoRepository;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

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

    public List<Todo> findByUserName(String username) {

        Predicate<Todo> predicate = todo -> todo.getUsername().equalsIgnoreCase(username);
        return todo.stream().filter(predicate).sorted((a, b) -> {
            if (a.getId() == b.getId()) return 0;
            else if (a.getId() < b.getId()) return 1;
            return -1;
        }).toList();
    }

    public Todo findById(int i) {
        Predicate<? super Todo> predicate = todo -> todo.getId() == i;

        Optional<Todo> s = todo.stream().filter(predicate).findFirst();

        return s.orElseGet(() -> new Todo(id++, "", "", null, false));

    }

    public void addTodo(String username, String description, LocalDate targetDate, boolean done) {
        logger.info("todo: {}", todo.size());
        todo.add(new Todo(id++, username, description, targetDate, done));
    }

    public void removeById(int i) {

        Predicate<? super Todo> predicate = todo -> todo.getId() == i;

        todo.removeIf(predicate);
    }

    public void updateTodo(@Valid Todo t) {
        int id = t.getId();
        removeById(id);
        todo.add(t);
    }
}
