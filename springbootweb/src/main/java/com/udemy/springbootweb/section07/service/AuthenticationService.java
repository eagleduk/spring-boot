package com.udemy.springbootweb.section07.service;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public boolean authenticate(String name, String password) {
        return "username".equalsIgnoreCase(name) && "password".equalsIgnoreCase(password);
    }
}
