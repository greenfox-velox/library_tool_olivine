package com.library.requests.book;

import com.library.model.business.Book;
import com.library.model.view.BookList;
import com.library.model.view.BookListItem;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class BookRequests {

    JdbcTemplate template;

    public BookRequests(DataSource ds) { template = new JdbcTemplate(ds); }

    public BookList listAllBooks() {
        BookList bookList = new BookList();
        for (BookListItem bookListItem : template.query("SELECT books.book_id, books.bookTitle, books.bookAuthor, books.bookPublishedIn, users.userName FROM books LEFT JOIN borrowings ON borrowings.book_id = books.book_id LEFT JOIN users ON users.user_id = borrowings.user_id", new BookMapper())) {
            bookList.books.add(bookListItem);
        }
        return bookList;
    }
}
