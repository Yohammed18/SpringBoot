package com.database.jpa.repository;

import com.database.jpa.model.Author;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {

//    @Query("select a from author a where a.name = :name")
//    List<Author> getAuthorByName(@Param("name") String name);
}
