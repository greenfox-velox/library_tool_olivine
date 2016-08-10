package library.Validator;

import com.library.JDBCTemplate.*;
import com.library.user.User;

public class Validator {

    JDBCTemplate myJDBCTemplate = new JDBCTemplate();

    public String registrationValidation(User regUser) {
        return myJDBCTemplate.registerUser(regUser);
    }
}