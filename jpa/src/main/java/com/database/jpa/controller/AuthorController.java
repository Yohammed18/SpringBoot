package com.database.jpa.controller;

import com.database.jpa.model.Author;
import com.database.jpa.service.AuthorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/authors")
public class AuthorController {

    private final AuthorService service;

    public AuthorController(AuthorService service) {
        this.service = service;
    }

    @GetMapping("/")
    public List<Author> getAuthors(){
        return service.getAuthors();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    void create(@RequestBody Author author){
        service.create(author);
    }


    @GetMapping("/{id}")
    public Author findAuthorById(@PathVariable Long id){
        return service.finById(id).stream().findFirst().get();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteAuthorById(@PathVariable Long id){
        service.deleteById(id);
    }

}
