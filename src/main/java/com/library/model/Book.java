package com.library.model;

import org.hibernate.validator.constraints.NotEmpty;

public class Book {

    @NotEmpty(message = "Please enter the title of the book")
    private String bookTitle;

    @NotEmpty(message = "Please enter the author of the book")
    private String bookAuthor;

    @NotEmpty(message = "Please enter the year of publishing as a number")
    private Integer bookPublishedIn;

    private String bookEdition;
    private String bookCover;
    private Integer bookISBNno;
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
        this.bookISBNno = 0;
        this.bookFormat = "";
        this.bookNumberOfPages = 0;
        this.bookInLanguage = "English";
        this.bookDescription = "No description added yet";
        this.bookIsBorrowed = false;
    }

    public Book() {}

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

    public void setBookISBNno(Integer bookISBNno) {
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

    public String getbookTitle() {return bookTitle;}

    public Integer getbookPublishedIn() {return bookPublishedIn;}

    public String getbookAuthor() {return bookAuthor;}

    public String getbookEdition() {return bookEdition;}

    public String getbookCover() {return bookCover;}

    public Integer getbookISBNno() {return bookISBNno;}

    public String getbookFormat() {return bookFormat;}

    public Integer getbookNumberOfPages() {return bookNumberOfPages;}

    public String getbookInLanguage() {return bookInLanguage;}

    public String getbookDescription() {return bookDescription;}

    public Boolean getbookIsBorrowed() {return bookIsBorrowed;}

}
