package com.database.jpa.service.Impl;

import com.database.jpa.model.Book;
import com.database.jpa.repository.BookRepository;
import com.database.jpa.service.BookService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository repository;

    public BookServiceImpl(BookRepository repository) {
        this.repository = repository;
    }

    public void create(Book book){
        repository.save(book);
    }

    public Optional<Book> findByIsbn(String isbn){
        return repository.findById(isbn);
    }

    public List<Book> findAll(){
        Iterable<Book> iterable = repository.findAll();
        List<Book> bookList = new ArrayList<>();

        for (var book : iterable) {
            bookList.add(book);
        }
        return bookList;
    }

    public void deleteByIsbn(String isbn){
        repository.deleteById(isbn);
    }

    public void saveAll(List<Book> books){
        repository.saveAll(books);
    }
}
