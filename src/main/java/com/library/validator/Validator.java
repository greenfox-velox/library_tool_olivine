package com.library.validator;

import com.library.JDBCTemplate.JDBCTemplate;
import com.library.user.User;

public class Validator {

    JDBCTemplate myJDBCTemplate = new JDBCTemplate();

    public String registrationValidation(User regUser) {
        return myJDBCTemplate.registerUser(regUser);
    }
}