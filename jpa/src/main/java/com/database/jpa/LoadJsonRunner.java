package com.database.jpa;

import com.database.jpa.model.Author;
import com.database.jpa.service.AuthorService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
@Component
public class LoadJsonRunner implements CommandLineRunner {

    private final AuthorService authorService;
    private final ObjectMapper objectMapper;

    public LoadJsonRunner(AuthorService authorService, ObjectMapper objectMapper) {
        this.authorService = authorService;
        this.objectMapper = objectMapper;
    }

        @Override
    public void run(String... args) throws Exception {
            //import list of authors from author.json
            try(InputStream stream = TypeReference.
                    class.getResourceAsStream("/data/author.json")){
                List<Author> authors = objectMapper
                        .readValue(stream, new TypeReference<List<Author>>() {});

                authorService.saveAll(authors);
            }catch (IOException e){
                System.err.println("ERROR: Unable to read JSON File");
            }
    }
}
