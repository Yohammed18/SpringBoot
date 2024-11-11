package com.database.jpa.service;

import com.database.jpa.model.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    public void createAuthor(Author author);


    public void saveAll(List<Author> authors);


    public Long authorsCount();

    public Optional<Author> finById(Long id);

    public void deleteById(Long id);

    public List<Author> getAuthors();
}
