package com.library.requests.user;

import com.library.model.business.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import javax.sql.DataSource;

public class UserRequests {

    JdbcTemplate template;

    public UserRequests(DataSource ds) {
        template = new JdbcTemplate(ds);
    }

    public void registerUser(User user) {
        String SQL = "insert into users (email, firstName, lastName, role, userName, password) values (?, ?, ?, ?, ?, ?)";
        template.update(SQL, user.getEmail(), user.getFirstName(), user.getLastName(), user.getRole(), user.getUserName(), user.getPassword());
    }

    public void getUser(User user) {

    }

    public boolean isUsernameFree(String userName) {
        for (User user : template.query("select * from users", new UserMapper())) {
            if (user.getUserName().equals(userName)) {
                return false;
            }
        }
        return true;
    }

    public boolean passwordEqualsConfPassword(User user) {
        return user.getPassword().equals(user.getConfPassword());
    }

    public void validate(User user, BindingResult result) {
        if (!isUsernameFree(user.getUserName())) {
            FieldError error = new FieldError("user", "userName", "This username is already in use");
            result.addError(error);
        }
        if (!passwordEqualsConfPassword(user)) {
            FieldError error = new FieldError("user", "password", "The passwords provided don't match");
            result.addError(error);
        }
    }
}
