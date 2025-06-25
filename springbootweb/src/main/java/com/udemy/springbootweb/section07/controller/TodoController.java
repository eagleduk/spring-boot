package com.udemy.springbootweb.section07.controller;

import com.udemy.springbootweb.section07.bean.Todo;
import com.udemy.springbootweb.section07.service.TodoService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("name")
public class TodoController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

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

    @RequestMapping(value="add-todo", method = RequestMethod.GET)
    public String addTodoPage(ModelMap model) {
        model.put("todo", new Todo(0, (String) model.get("name"), "", LocalDate.now(), false));
        return "addTodo";
    }

    @RequestMapping(value="add-todo", method = RequestMethod.POST)
    public String addTodo(ModelMap model, @Valid Todo todo, BindingResult result) {

        if(result.hasErrors()) {
            return "addTodo";
        }

        todoService.addTodo(todo.getUsername(), todo.getDescription(), todo.getTargetDate(), todo.isDone());
        return "redirect:list-todo";
    }

    @RequestMapping(value="delete-todo", method = RequestMethod.GET)
    public String deleteTodo(@RequestParam int id) {

        todoService.removeById(id);

        return "redirect:list-todo";
    }
}
