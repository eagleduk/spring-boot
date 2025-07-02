package com.udemy.springbootweb.section08.service;

import com.udemy.springbootweb.section08.bean.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Component
public class UserService {

    private Integer count = 1;

    private final List<User> users = new ArrayList<>();

    public List<User> findAll() {
        return users;
    }

    public Optional<User> findById(Integer id) {
        Predicate<User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst();
    }

    public User save(User user) {
        user.setId(count++);

        users.add(user);

        return user;
    }

    public void deleteById(Integer id) {
        Predicate<User> predicate = user -> user.getId().equals(id);
        User target = users.stream().filter(predicate).findFirst().orElse(null);
        users.remove(target);
    }
}
