package com.library.model;

public class Book{

    public String title;

    public String author;

    public String status;

    public int isbn;

    public Book (String title, String author, String status, int isbn) {
        this.title = title;
        this.author = author;
        this.status = "borrowable"; //override in DB for "admin" if needed;
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }
}
