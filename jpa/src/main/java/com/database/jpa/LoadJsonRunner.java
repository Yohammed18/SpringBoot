package com.database.jpa;

import com.database.jpa.model.Author;
import com.database.jpa.model.Book;
import com.database.jpa.service.AuthorService;
import com.database.jpa.service.BookService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
@Component
public class LoadJsonRunner implements CommandLineRunner {

    private final AuthorService authorService;
    private final ObjectMapper objectMapper;
    private final BookService bookService;


    public LoadJsonRunner(AuthorService authorService, ObjectMapper objectMapper, BookService bookService) {
        this.authorService = authorService;
        this.objectMapper = objectMapper;
        this.bookService = bookService;
    }

        @Override
    public void run(String... args) throws Exception {
            //import list of authors from author.json
            try(InputStream stream = TypeReference.
                    class.getResourceAsStream("/data/author.json")){
                List<Author> authors = objectMapper
                        .readValue(stream, new TypeReference<List<Author>>() {});

                authorService.saveAll(authors);
            }catch (IOException e){
                System.err.println("ERROR: Unable to read JSON File");
            }

            //import list of authors from book.json
            try(InputStream stream = TypeReference.
                    class.getResourceAsStream("/data/book.json")){
                List<Book> books = objectMapper
                        .readValue(stream, new TypeReference<List<Book>>() {});
                bookService.saveAll(books);
            }catch (IOException e){
                System.err.println("ERROR: Unable to read JSON File");
            }

    }
}
