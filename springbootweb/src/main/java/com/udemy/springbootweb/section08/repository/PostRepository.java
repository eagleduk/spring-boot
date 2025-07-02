package com.udemy.springbootweb.section08.repository;

import com.udemy.springbootweb.section08.bean.Post;
import com.udemy.springbootweb.section08.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {

    public List<Post> findByUser(User user);
}
