package com.database.jpa.service.Impl;

import com.database.jpa.model.Author;
import com.database.jpa.model.Dto.AuthorDTO;
import com.database.jpa.repository.AuthorRepository;
import com.database.jpa.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository repository;

    public AuthorServiceImpl(AuthorRepository repository) {
        this.repository = repository;
    }

    public void createAuthor(Author author){
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


    public List<Author> getAuthors(){
        Iterable<Author> iterable = repository.findAll();
        List<Author> authorList = new ArrayList<>();

        for (var author : iterable) {
            authorList.add(author);
        }
        return authorList;
    }

}
