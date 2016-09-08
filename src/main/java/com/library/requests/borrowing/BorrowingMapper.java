package com.library.requests.borrowing;

import com.library.model.business.Borrowing;
import com.library.model.view.BookListItem;
import com.library.model.view.BorrowingListItem;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

//returns the users from DB one by one in a model object with userName, email and password in the constructor

public class BorrowingMapper implements RowMapper<BorrowingListItem> {
    public BorrowingListItem mapRow(ResultSet rs, int rowNum) throws SQLException {
        BorrowingListItem borrowingListItem = new BorrowingListItem();
        borrowingListItem.setBorrowing_id(rs.getInt("borrowing_id"));
        borrowingListItem.setUserName(rs.getString("userName"));
        borrowingListItem.setBookTitle(rs.getString("bookTitle"));
        borrowingListItem.setBorrowingDate(rs.getDate("borrowingDate"));
        return borrowingListItem;
    }
}