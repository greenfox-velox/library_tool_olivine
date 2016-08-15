package com.library.validator;


import com.library.JDBCTemplate;
import com.library.user.User;
import com.library.userRequests.userRequests;

public class Validator {

    userRequests requests = new userRequests();

    public String registrationValidation(User regUser) {
        return requests.registerUser(regUser);
    }
}