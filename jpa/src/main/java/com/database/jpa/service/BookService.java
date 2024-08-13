package com.database.jpa.service;

import com.database.jpa.model.Book;
import com.database.jpa.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository repository;


    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public void create(Book book){
        repository.save(book);
    }

    public Optional<Book> findByIsbn(String isbn){
        return repository.findById(isbn);
    }

    public List<Book> findAll(){
        return repository.findAll();
    }

    public void deleteByIsbn(String isbn){
        repository.deleteById(isbn);
    }

    public void saveAll(List<Book> books){
        repository.saveAll(books);
    }
}
