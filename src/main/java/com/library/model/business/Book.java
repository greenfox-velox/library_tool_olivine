    package com.library.model.business;

import org.hibernate.validator.constraints.NotEmpty;

public class Book {

    private int book_id;

    @NotEmpty(message = "Please enter the title of the book")
    private String bookTitle;

    @NotEmpty(message = "Please enter the author of the book")
    private String bookAuthor;

    @NotEmpty(message = "Please enter the year of publishing as a number")
    private Integer bookPublishedIn;

    private String bookEdition;
    private String bookCover;
    private String bookISBNno;
    private String bookFormat;
    private Integer bookNumberOfPages;
    private String bookInLanguage;
    private String bookDescription;
    private Boolean bookIsBorrowed;

    public Book(String bookTitle, Integer bookPublishedIn, String bookAuthor) {
        this.bookTitle = bookTitle;
        this.bookPublishedIn = bookPublishedIn;
        this.bookAuthor = bookAuthor;
        this.bookEdition = "";
        this.bookCover = "";
        this.bookISBNno = "";
        this.bookFormat = "";
        this.bookNumberOfPages = 0;
        this.bookInLanguage = "English";
        this.bookDescription = "No description added yet";
        this.bookIsBorrowed = false;
    }

    public Book() {}

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public void setBookPublishedIn(Integer bookPublishedIn) {
        this.bookPublishedIn = bookPublishedIn;
    }

    public void setBookEdition(String bookEdition) {
        this.bookEdition = bookEdition;
    }

    public void setBookCover(String bookCover) {
        this.bookCover = bookCover;
    }

    public void setBookISBNno(String bookISBNno) {
        this.bookISBNno = bookISBNno;
    }

    public void setBookFormat(String bookFormat) {
        this.bookFormat = bookFormat;
    }

    public void setBookNumberOfPages(Integer bookNumberOfPages) {
        this.bookNumberOfPages = bookNumberOfPages;
    }

    public void setBookInLanguage(String bookInLanguage) {
        this.bookInLanguage = bookInLanguage;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }

    public void setBookIsBorrowed(Boolean bookIsBorrowed) {
        this.bookIsBorrowed = bookIsBorrowed;
    }

    public int getBook_id() {
        return book_id;
    }

    public String getBookTitle() {return bookTitle;}

    public Integer getBookPublishedIn() {return bookPublishedIn;}

    public String getBookAuthor() {return bookAuthor;}

    public String getBookEdition() {return bookEdition;}

    public String getBookCover() {return bookCover;}

    public String getBookISBNno() {return bookISBNno;}

    public String getBookFormat() {return bookFormat;}

    public Integer getBookNumberOfPages() {return bookNumberOfPages;}

    public String getBookInLanguage() {return bookInLanguage;}

    public String getBookDescription() {return bookDescription;}

    public Boolean getBookIsBorrowed() {return bookIsBorrowed;}

}
