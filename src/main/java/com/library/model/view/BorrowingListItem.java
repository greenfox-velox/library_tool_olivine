package com.library.model.view;

import java.util.Date;

public class BorrowingListItem {
    private int borrowing_id;
    private String userName;
    private String bookTitle;
    private Date borrowingDate;

    public BorrowingListItem(int borrowing_id, String userName, String bookTitle, Date borrowingDate){
        this.borrowing_id = borrowing_id;
        this.userName = userName;
        this.bookTitle = bookTitle;
        this.borrowingDate = borrowingDate;
    }

    public BorrowingListItem() {}

    public String getUserName() {
        return userName;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public Date getBorrowingDate() {
        return borrowingDate;
    }

    public int getBorrowing_id() {
        return borrowing_id;
    }

    public void setBorrowing_id(int borrowing_id) {
        this.borrowing_id = borrowing_id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public void setBorrowingDate(Date borrowingDate) {
        this.borrowingDate = borrowingDate;
    }
}
