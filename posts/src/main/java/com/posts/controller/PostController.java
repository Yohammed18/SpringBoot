package com.posts.controller;

import com.posts.record.Post;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {

    private static final Logger log = LoggerFactory.getLogger(PostController.class);
    private final RestPostClient postClient;

    public PostController(RestPostClient postClient) {
        this.postClient = postClient;
    }

    @GetMapping("/welcome")
    public String postWelcome(){
        return "Welcome to the Post Page!";
    }

    @GetMapping("/posts")
    List<Post> findAll(){
        return postClient.findAll();
    }
    @GetMapping("/post/{id}")
    Post findById(@PathVariable Integer Id){
        return postClient.findById(Id);
    }

}
