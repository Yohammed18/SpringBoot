package com.posts;

import com.posts.controller.RestPostClient;
import com.posts.record.Post;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class PostsApplication {

	private final static Logger log = LoggerFactory.getLogger(PostsApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(PostsApplication.class, args);
	}


	@Bean
	CommandLineRunner runner(RestPostClient postClient){
		return args -> {
			log.info("Welcome to the Post Client Application");

//			List<Post> posts = postClient.findAll();
//			log.info("Fetch posts: {}", posts);
			Integer id = 3;
			Post post = postClient.findById(id);
			log.info("Fetch post by id {}: \n{}.", post.id(), post.title());
		};
	}
}
