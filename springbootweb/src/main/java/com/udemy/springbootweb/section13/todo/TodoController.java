package com.udemy.springbootweb.section13.todo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService t) {
        this.todoService = t;
    }

    @GetMapping("/users/{username}/todos")
    public List<Todo> getTodoByUserName(@PathVariable String username) {
        return todoService.findByUsername(username);
    }

    @GetMapping("/users/{username}/todos/{id}")
    public Todo getTodoByUserName(@PathVariable String username, @PathVariable int id) {
        return todoService.findById(id);
    }

    @PostMapping("/users/{username}/todos")
    public ResponseEntity<?> createTodo(@PathVariable String username, @RequestBody Todo todo) {
        Todo newTodo = todoService.addTodo(username, todo.getDescription(), todo.getTargetDate(), todo.isDone());
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newTodo.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/users/{username}/todos/{id}")
    public ResponseEntity<?> updateTodo(@PathVariable String username, @PathVariable int id, @RequestBody Todo todo) {
        todo.setId(id);
        todoService.updateTodo(todo);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{username}/todos/{id}")
    public ResponseEntity<?> deleteTodoById(@PathVariable String username, @PathVariable int id) {
        todoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
