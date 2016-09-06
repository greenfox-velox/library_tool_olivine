package com.library.model;

import java.util.Date;

public class Borrowing {
    private int borrowing_id;
    private int book_id;
    private int user_id;
    private Date borrowingDate;

    public Borrowing(int book_id, int user_id, Date date){
        this.book_id = book_id;
        this.user_id = user_id;
        this.borrowingDate = new Date();
    }

    public Borrowing() {}

    public int getBorrowing_id() {
        return borrowing_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public Date getBorrowingDate() {
        return borrowingDate;
    }

    public void setBorrowing_id(int borrowing_id) {
        this.borrowing_id = borrowing_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public void setBorrowingDate(Date date) {
        this.borrowingDate = date;
    }
}

