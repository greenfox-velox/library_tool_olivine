package com.library.model.view;

public class BookListItem {
    private int book_id;
    private String bookTitle;
    private String bookAuthor;
    private Integer bookPublishedIn;
    private String userName = "";

    public BookListItem(int book_id, String bookTitle, String bookAuthor, Integer bookPublishedIn, String userName) {
        this.book_id = book_id;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookPublishedIn = bookPublishedIn;
        this.userName = userName;
    }

    public BookListItem() {}

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public void setBookPublishedIn(Integer bookPublishedIn) {
        this.bookPublishedIn = bookPublishedIn;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getBook_id() {
        return book_id;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public Integer getBookPublishedIn() {
        return bookPublishedIn;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getUserName() {
        return userName;
    }
}
