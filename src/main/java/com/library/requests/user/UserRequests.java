package com.library.requests.user;

import com.library.model.business.User;
import com.library.model.view.UserList;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class UserRequests {

    JdbcTemplate template;

    public UserRequests(DataSource ds) {
        template = new JdbcTemplate(ds);
    }

    public void registerUser(User user) {
        String SQL = "insert into users (email, firstName, lastName, role, userName, password) values (?, ?, ?, ?, ?, ?)";
        template.update(SQL, user.getEmail(), user.getFirstName(), user.getLastName(), "user", user.getUserName(), user.getPassword());
    }

    public UserList getAllUsers() {
        UserList userList = new UserList();
        for (User user :  template.query("SELECT * FROM users", new UserMapper())) {
            userList.users.add(user);
        }
        return userList;
    }

    public User getUserById(int id) {
        for (User user : template.query("select * from users", new UserMapper())) {
            if (user.getUser_id() == (id)) {
                return user;
            }
        }
        return new User();
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
