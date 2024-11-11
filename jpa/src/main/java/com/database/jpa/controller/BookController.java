package com.database.jpa.controller;

import com.database.jpa.model.Book;
import com.database.jpa.service.Impl.BookServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("api/books")
public class BookController {

    private final BookServiceImpl bookService;

    public BookController(BookServiceImpl bookService) {
        this.bookService = bookService;
    }

    @GetMapping(path="/")
    public List<Book> findAllBooks(){
        return bookService.findAll();
    }
}
