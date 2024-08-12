package com.database.jdbc.domain.dao;

import com.database.jdbc.domain.model.Book;

import java.util.List;

public interface BookDao {

    void create(Book book);


    List<Book> findAllBooks();
}
