package com.udemy.springbootweb.section08.controller;

import com.udemy.springbootweb.section08.bean.User;
import com.udemy.springbootweb.section08.exception.UserNotFoundException;
import com.udemy.springbootweb.section08.repository.UserRepository;
import com.udemy.springbootweb.section08.service.UserService;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {

//    private UserService userService;
//
//    public UserController(UserService u) {
//        this.userService = u;
//    }

    private UserRepository userRepository;

    public UserController(UserRepository u) {
        this.userRepository = u;
    }


    @GetMapping("/users")
    public List<User> findUser() {
        return userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public EntityModel<User> findById(@PathVariable Integer id) {
        User user = userRepository.findById(id).orElse(null);
        if(user == null) {
            throw new UserNotFoundException("Not Found: " + id);
        }

        EntityModel<User> entityModel = EntityModel.of(user);
        WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).findUser());
        entityModel.add(link.withRel("findUser"));

        return entityModel;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(
            @Valid @RequestBody User user) {
        User newUser = userRepository.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newUser.getId()).toUri();

        return ResponseEntity.created(location).body(newUser);
    }

    @DeleteMapping("/users/{id}")
    public void delete(@PathVariable Integer id) {
        userRepository.deleteById(id);
    }
}
