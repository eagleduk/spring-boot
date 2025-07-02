package com.udemy.springbootweb.section08.repository;

import com.udemy.springbootweb.section08.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
