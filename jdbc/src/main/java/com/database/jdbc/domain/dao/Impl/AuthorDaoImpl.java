package com.database.jdbc.domain.dao.Impl;

import com.database.jdbc.domain.dao.AuthorDao;
import com.database.jdbc.domain.model.Author;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuthorDaoImpl implements AuthorDao {

    private final JdbcTemplate jdbcTemplate;

    public AuthorDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Author author) {
        jdbcTemplate.update(
          "INSERT INTO author (id, name, age) VALUES (?, ?, ?)",
          author.getId(),author.getName(),author.getAge()
        );
    }

    @Override
    public List<Author> findAllAuthors() {
        return jdbcTemplate.query("SELECT * FROM author", (rs, rowNum) ->
                new Author(
                   rs.getLong("id"),
                   rs.getString("name"),
                   rs.getInt("age")
                ));
    }

    @Override
    public void saveAll(List<Author> authors) {
        for (var author : authors) {
            jdbcTemplate.update("INSERT INTO author (id, name, age) VALUES (?, ?, ?)",
                    author.getId(), author.getName(), author.getAge());
        }
    }

    @Override
    public Author findAuthorById(Integer id) {
        return jdbcTemplate.queryForObject("SELECT * FROM public.author where id = ?",
                new Object[]{id},
                new BeanPropertyRowMapper<>(Author.class));
    }


}
