package com.library.userRequests;

import com.library.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import javax.sql.DataSource;

public class UserRequests {

    JdbcTemplate template;

    public UserRequests(DataSource ds) {
        template = new JdbcTemplate(ds);
    }

    public void userValidator(User user, BindingResult result){
        if(!isUsernameFree(user.getUserName())){
            FieldError error = new FieldError("user", "userName", "This username is already exists");
            result.addError(error);
        }
        if(!passwordCheck(user)){
            FieldError error = new FieldError("user", "password", "Password is not same as conf pass");
            result.addError(error);
        }
    }

    public void registerUser(User user) {
        String SQL = "insert into users (email, firstName, lastName, role, userName, password) values (?, ?, ?, ?, ?, ?)";
        template.update(SQL, user.getEmail(), user.getFirstName(), user.getLastName(), user.getRole(), user.getUserName(), user.getPassword());
    }


    public boolean isUsernameFree(String userName) {
        for (User user : template.query("select * from users", new UserMapper())) {
            if (user.getUserName().equals(userName)) {
                return false;
            }
        }
        return true;
    }


    public boolean passwordCheck(User user) {
        return user.getPassword().equals(user.getConfPassword());
    }


}
