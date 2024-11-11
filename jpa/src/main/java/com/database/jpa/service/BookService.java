package com.database.jpa.service;

import com.database.jpa.model.Book;
import com.database.jpa.repository.BookRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface BookService {

    public void create(Book book);

    public Optional<Book> findByIsbn(String isbn);

    public List<Book> findAll();

    public void deleteByIsbn(String isbn);

    public void saveAll(List<Book> books);
}

