package com.database.jdbc.domain.dao;

import com.database.jdbc.domain.model.Book;

import java.util.List;

public interface BookDao {

    void create(Book book);


    List<Book> findAllBooks();

    void saveAll(List<Book> books);
    Book findById(String isbn);

    Book findBookByAuthorId(Long id);
}
