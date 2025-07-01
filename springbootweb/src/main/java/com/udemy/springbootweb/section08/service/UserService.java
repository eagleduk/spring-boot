package com.udemy.springbootweb.section08.service;

import com.udemy.springbootweb.section08.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserService {

    private Integer count = 1;

    private final List<User> users = new ArrayList<>();

    public List<User> findUser() {
        return users;
    }

    public User findUser(Integer id) {
        Predicate<User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().orElse(null);
    }

    public User createUser(User user) {
        user.setId(count++);

        users.add(user);

        return user;
    }
}
