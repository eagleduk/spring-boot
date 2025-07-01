package com.udemy.springbootweb.section07.controller;

import com.udemy.springbootweb.section07.bean.Todo;
import com.udemy.springbootweb.section07.repository.TodoRepository;
import com.udemy.springbootweb.section07.service.TodoService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@SessionAttributes("name")
public class TodoJPAController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private TodoRepository todoRepository;
    
    private final TodoService todoService;

    public TodoJPAController(TodoService todoService) {
        this.todoService = todoService;
    }

    private String getUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

    @RequestMapping("list-todo")
    public String listTodo(ModelMap model) {

        String username = getUsername();

        List<Todo> todo = todoRepository.findByUsername(username);

        model.put("todo", todo);
        return "listTodo";
    }

    @RequestMapping(value="add-todo", method = RequestMethod.GET)
    public String addTodoPage(ModelMap model) {
        model.put("todo", new Todo(0, getUsername(), "", LocalDate.now(), false));
        return "todo";
    }

    @RequestMapping(value="add-todo", method = RequestMethod.POST)
    public String addTodo(@Valid Todo todo, BindingResult result) {

        if(result.hasErrors()) {
            return "todo";
        }

        Todo newTodo = new Todo(todo.getUsername(), todo.getDescription(), todo.getTargetDate(), todo.isDone());
        
        todoRepository.save(newTodo);
        return "redirect:list-todo";
    }

    @RequestMapping(value="delete-todo", method = RequestMethod.GET)
    public String deleteTodo(@RequestParam int id) {

        todoRepository.deleteById(id);

        return "redirect:list-todo";
    }

    @RequestMapping(value="update-todo", method = RequestMethod.GET)
    public String updateTodoPage(ModelMap model, @RequestParam int id) {

        Optional<Todo> o = todoRepository.findById(id);

        if(o.isEmpty()) {
            return "redirect:list-todo";
        }

        Todo todo = o.get();
        model.put("todo", todo);
        return "todo";
    }

    @RequestMapping(value="update-todo", method = RequestMethod.POST)
    public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {

        if(result.hasErrors()) {
            return "redirect:update-todo";
        }
        todoRepository.save(todo);

        return "redirect:list-todo";
    }
}
