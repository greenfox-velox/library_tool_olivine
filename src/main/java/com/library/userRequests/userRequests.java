package com.library.userRequests;

//import com.library.config.JDBCTemplate;
import com.library.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.session.SessionProperties;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Created by Attila on 15/08/2016.
 */
public class userRequests {

    JdbcTemplate template;

    public userRequests(DataSource ds) {
        template = new JdbcTemplate(ds);

    }
//
//    public String registrationValidation(User regUser) {
//        return registerUser(regUser);
//    }

    public String registerUser(User user) {
        if (isUsernameFree(user.getUserName()) && passwordCheck(user)) {
            String SQL = "insert into users (email, firstName, lastName, role, userName, password) values (?, ?, ?, ?, ?, ?)";
            template.update(SQL, user.getEmail(), user.getFirstName(), user.getLastName(), user.getRole(), user.getUserName(), user.getPassword());
            return "welcome";
        } else {
            return "registration";
        }
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
