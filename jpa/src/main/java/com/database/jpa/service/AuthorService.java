package com.database.jpa.service;

import com.database.jpa.model.Author;
import com.database.jpa.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    private final AuthorRepository repository;

    public AuthorService(AuthorRepository repository) {
        this.repository = repository;
    }

    public void create(Author author){
        repository.save(author);
    }


    public void saveAll(List<Author> authors){
        repository.saveAll(authors);
    }


    public Long authorsCount(){
        return repository.count();
    }

    public Optional<Author> finById(Long id){
        return repository.findById(id);
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }

//    public List<Author> getAuthorsByName(String name){
//        return repository.getAuthorByName(name);
//    }
}
