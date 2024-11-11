package com.database.jpa.controller;

import com.database.jpa.mappers.Mapper;
import com.database.jpa.model.Author;
import com.database.jpa.model.Dto.AuthorDTO;
import com.database.jpa.service.Impl.AuthorServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/authors")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthorController {

    private final AuthorServiceImpl service;
    private final Mapper<Author, AuthorDTO> mapper;

    public AuthorController(AuthorServiceImpl service, Mapper<Author, AuthorDTO> mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping("/")
    public List<Author> getAuthors(){
        return service.getAuthors();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    void create(@RequestBody AuthorDTO authorDTO){
        Author author = mapper.mapFrom(authorDTO);
        service.createAuthor(author);
    }


    @GetMapping("/{id}")
    public Author findAuthorById(@PathVariable Long id){
        return service.finById(id).stream().findFirst().get();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete/{id}")
    public void deleteAuthorById(@PathVariable Long id){
        service.deleteById(id);
    }

}
