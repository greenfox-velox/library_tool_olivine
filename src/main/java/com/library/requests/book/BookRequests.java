package com.library.requests.book;

import com.library.model.Book;
import com.library.model.BookList;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class BookRequests {

    JdbcTemplate template;

    public BookRequests(DataSource ds) { template = new JdbcTemplate(ds); }

    public BookList listAllBooks() {
        BookList bookList = new BookList();
        for (Book book : template.query("select * from books", new BookMapper())) {
            bookList.books.add(book);
        }
        return bookList;
    }
}
