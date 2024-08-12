package com.database.jpa;

import com.database.jpa.model.Author;
import com.database.jpa.service.AuthorService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
@Slf4j
public class JpaApplication {

	private final AuthorService authorService;
	private final ObjectMapper objectMapper;


	public JpaApplication(AuthorService authorService, ObjectMapper objectMapper) {

		this.authorService = authorService;
		this.objectMapper = objectMapper;
	}

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}


	@Bean
	CommandLineRunner runner(){
		return args -> {
//			//Create author
//			Author author = Author.builder()
//					.id(1L)
//					.name("Mohammed Basimal")
//					.age(32)
//					.build();
//
//			authorService.create(author);
//			Optional<Author> findAuthor = authorService.finById(1L);
//
//			System.out.println(findAuthor.toString());

			//import list of authors from author.json
			try(InputStream stream = TypeReference.
					class.getResourceAsStream("/data/author.json")){
				List<Author> authors = objectMapper
						.readValue(stream, new TypeReference<List<Author>>() {});

				authorService.saveAll(authors);
			}catch (IOException e){
				System.err.println("ERROR: Unable to read JSON File");
			}

//			System.out.println("TEST");
//			System.out.println("Retrieve an author by name");
//			List<Author> author = authorService.getAuthorsByName("George Orwell");

//			System.out.println(author.toString());
		};
	}
}
