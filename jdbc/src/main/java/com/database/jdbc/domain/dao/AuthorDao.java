package com.database.jdbc.domain.dao;

import com.database.jdbc.domain.model.Author;

import java.util.List;

public interface AuthorDao {

    void create(Author author);
    List<Author> findAllAuthors();
}
