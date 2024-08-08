package com.posts.controller;

import com.posts.record.Post;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestClient;

import java.util.List;

@Component
public class RestPostClient {

    private static final Logger log = LoggerFactory.getLogger(RestPostClient.class);
    private final RestClient builder;
    public RestPostClient(RestClient.Builder builder){
        this.builder = builder.baseUrl("https://jsonplaceholder.typicode.com/posts").build();
    }


    //get all post record
    public List<Post> findAll(){
        return builder.get()
                .uri("")
                .retrieve()
                .body(new ParameterizedTypeReference<List<Post>>(){
        });
    }

    //Get post by id
    public Post findById(@PathVariable Integer id){
        return builder.get()
                .uri("/{id}", id)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(Post.class);
    }



}
