package com.database.jpa;

import com.database.jpa.model.Author;
import com.database.jpa.model.Book;
import com.database.jpa.model.Dto.BookDTO;
import com.database.jpa.service.AuthorService;
import com.database.jpa.service.BookService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
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
            try(InputStream authorStream = TypeReference.
                    class.getResourceAsStream("/data/author.json")){
                List<Author> authors = objectMapper
                        .readValue(authorStream, new TypeReference<List<Author>>() {});

                authorService.saveAll(authors);
            }catch (IOException e){
                System.err.println("ERROR: Unable to read author.json File");
            }

            //import list of authors from book.json
            try(InputStream bookStream = TypeReference.
                    class.getResourceAsStream("/data/book.json")){
                List<BookDTO> bookDTOS = objectMapper.readValue(bookStream, new TypeReference<List<BookDTO>>() {});

                List<Book> books = bookDTOS.stream().map(dto -> {
                    Author author = authorService.finById(dto.getAuthorId()).get();
                    return new Book(dto.getIsbn(), dto.getTitle(), author);
                }).collect(Collectors.toList());

                bookService.saveAll(books);
            }catch (IOException e){
                System.err.println("ERROR: Unable to read book.json File: "+e.getMessage());
            }

    }
}
