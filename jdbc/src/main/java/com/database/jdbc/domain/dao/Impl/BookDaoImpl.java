package com.database.jdbc.domain.dao.Impl;

import com.database.jdbc.domain.dao.BookDao;
import com.database.jdbc.domain.model.Book;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.util.List;
@Component
public class BookDaoImpl implements BookDao {

    private final JdbcTemplate jdbcTemplate;

    public BookDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Book book) {
        jdbcTemplate.update(
                "INSERT INTO book (isbn, title, author_id) VALUES (?, ?, ?)",
                book.getIsbn(), book.getTitle(), book.getAuthorId());
    }

    @Override
    public List<Book> findAllBooks() {
        return jdbcTemplate.query("SELECT * FROM book", (rs, rowNum) ->
                new Book(
                        rs.getString("isbn"),
                        rs.getString("title"),
                        rs.getLong("author_id")
                ));
    }

    @Override
    public void saveAll(List<Book> books) {
        for (var book: books) {
            jdbcTemplate.update("INSERT INTO book (isbn, title, author_id) VALUES (?, ?, ?)",
                    book.getIsbn(), book.getTitle(), book.getAuthorId());
        }
    }

    @Override
    public Book findById(String isbn) {
        return jdbcTemplate.queryForObject("SELECT * FROM book where isbn = ?",
                new Object[]{isbn},
                new BeanPropertyRowMapper<>(Book.class));
    }

    @Override
    public Book findBookByAuthorId(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM book where author_id = ?",
                new Object[]{id},
                new BeanPropertyRowMapper<>(Book.class));
    }


}
