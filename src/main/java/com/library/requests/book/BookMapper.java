package com.library.requests.book;

import com.library.model.Book;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

//returns the users from DB one by one in a model object with userName, email and password in the constructor

public class BookMapper implements RowMapper<Book> {
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        Book book = new Book();
        book.setBook_id(rs.getInt("book_id"));
        book.setBookTitle(rs.getString("bookTitle"));
        book.setBookAuthor(rs.getString("bookAuthor"));
        book.setBookPublishedIn(rs.getInt("bookPublishedIn"));
        return book;
    }
}