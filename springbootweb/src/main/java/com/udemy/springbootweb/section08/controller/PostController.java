package com.udemy.springbootweb.section08.controller;

import com.udemy.springbootweb.section08.bean.Post;
import com.udemy.springbootweb.section08.bean.User;
import com.udemy.springbootweb.section08.exception.PostNotFoundException;
import com.udemy.springbootweb.section08.exception.UserNotFoundException;
import com.udemy.springbootweb.section08.repository.PostRepository;
import com.udemy.springbootweb.section08.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    private UserRepository userRepository;

    private PostRepository postRepository;

    public PostController(UserRepository u, PostRepository p) {
        this.userRepository = u;
        this.postRepository = p;
    }

    @GetMapping("/users/{id}/posts")
    public List<Post> getPosts(@PathVariable Integer id) {
        User user = userRepository.findById(id).orElse(null);

        if(user == null)
            throw new UserNotFoundException("Not Found User: " + id);

        return postRepository.findByUser(user);
    }

    @PostMapping("/users/{id}/posts")
    public Post createPost(@PathVariable Integer id, @RequestBody Post post) {
        User user = userRepository.findById(id).orElse(null);

        if(user == null)
            throw new UserNotFoundException("Not Found User: " + id);

        post.setUser(user);

        postRepository.save(post);

        return post;
    }

    @GetMapping("/users/{user_id}/posts/{id}")
    public Post getPost( @PathVariable Integer id) {
        Post post = postRepository.findById(id).orElse(null);

        if(post == null)
            throw new PostNotFoundException("Not Found Post: " + id);

        return post;
    }

    @DeleteMapping("/users/{user_id}/posts/{id}")
    public void deletePost( @PathVariable Integer id) {
        postRepository.deleteById(id);
    }
}
