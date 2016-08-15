package com.library.userRequests;

import com.library.JDBCTemplate;
import com.library.UserMapper;
import com.library.user.User;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by Attila on 15/08/2016.
 */
public class userRequests {

    JDBCTemplate template = new JDBCTemplate();

    public String registerUser(User user) {
        if (isUsernameFree(user.getUserName()) && passwordCheck(user)) {
            String SQL = "insert into users (email, firstName, lastName, role, userName, password) values (?, ?, ?, ?, ?, ?)";
            template.templateObject.update(SQL, user.getEmail(), user.getFirstName(), user.getLastName(), user.getRole(), user.getUserName(), user.getPassword());
            return "welcome";
        } else {
            return "registration";
        }
    }

    public boolean isUsernameFree(String userName) {
        for (User user : template.templateObject.query("select * from users", new UserMapper())) {
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
