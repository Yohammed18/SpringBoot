package com.database.jdbc;


import com.database.jdbc.domain.dao.Impl.BookDaoImpl;
import com.database.jdbc.domain.model.Author;
import com.database.jdbc.domain.model.Book;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.database.jdbc.domain.dao.Impl.AuthorDaoImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;


@SpringBootApplication
@Log4j2
public class JdbcApplication {

	private final ObjectMapper objectMapper;
	private final AuthorDaoImpl authorDao;
	private final BookDaoImpl bookDao;

	public JdbcApplication(ObjectMapper objectMapper, AuthorDaoImpl authorDao, BookDaoImpl bookDao) {
		this.objectMapper = objectMapper;
		this.authorDao = authorDao;
		this.bookDao = bookDao;
	}

	public static void main(String[] args) {
		SpringApplication.run(JdbcApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(){
		return args -> {
			log.info("\nWelcome to the JDBC Application");
			log.info("LOAD Book and Author data");

			//Read JSON file and map to a list of Books and Authors

			try{
				List<Author> authors = objectMapper
						.readValue(TypeReference.class.getResourceAsStream("/data/authors.json"),
								new TypeReference<List<Author>>() {});

				List<Book> books = objectMapper
						.readValue(TypeReference.class.getResourceAsStream("/data/books.json"),
								new TypeReference<List<Book>>() {});

				// Save the files into the database

				authorDao.saveAll(authors);
				bookDao.saveAll(books);

				System.out.println("The data in both authors a" +
						"nd books JSON file has been saved in the database.\n\n");

				System.out.println("TEST");
				System.out.println("Get author with Id 5 and Book by providing id of user.");
				Author authorId5 = authorDao.findAuthorById(5);
				Book book = bookDao.findBookByAuthorId(authorId5.getId());
				System.out.println(authorId5.toString());
				System.out.println(book.toString());
			} catch (IOException e){
				System.err.println("Error reading or parsing JSON file: "+e.getMessage());
			}
		};
	}
}
