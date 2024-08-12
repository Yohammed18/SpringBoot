package com.database.jdbc;


import com.database.jdbc.domain.dao.Impl.BookDaoImpl;
import com.database.jdbc.domain.model.Author;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.database.jdbc.domain.dao.Impl.AuthorDaoImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;


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
				//Create Author
			Author newAuthor = Author.builder()
					.id(12L)
					.name("James Bronw")
					.age(32)
					.build();
			authorDao.create(newAuthor);
			System.out.println("\nLIST OF ALL AUTHORS");
			System.out.println(authorDao.findAllAuthors().size());
		};
	}
}
