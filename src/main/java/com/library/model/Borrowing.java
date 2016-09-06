package com.library.model;

import java.util.Date;

public class Borrowing {
    private int book_id;
    private int user_id;
    private Date date;

    public Borrowing(int book_id, int user_id, Date date){
        this.book_id = book_id;
        this.user_id = user_id;
        this.date = new Date();
    }

    public Borrowing() {}

    public int getUser_id() {
        return user_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public Date getDate() {
        return date;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
