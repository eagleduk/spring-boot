package com.udemy.springbootweb.section07.controller;

import com.udemy.springbootweb.section07.bean.Todo;
import com.udemy.springbootweb.section07.service.TodoService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@SessionAttributes("name")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping("list-todo")
    public String listTodo(ModelMap model) {
        List<Todo> todo = todoService.findByUserName();

        model.put("todo", todo);
        return "listTodo";
    }
}
