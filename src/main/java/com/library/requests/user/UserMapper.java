package com.library.requests.user;

import com.library.model.business.User;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;


//returns the users from DB one by one in a model object with userName, email and password in the constructor


public class UserMapper implements RowMapper<User> {
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setUser_id(rs.getInt("user_id"));
        user.setUserName(rs.getString("userName"));
        user.setFirstName(rs.getString("firstName"));
        user.setLastName(rs.getString("lastName"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        user.setProject(rs.getString("project"));
        user.setRole(rs.getString("role"));
        return user;
    }
}