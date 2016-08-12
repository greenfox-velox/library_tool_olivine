package com.library;

import com.library.user.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.net.URI;
import java.net.URISyntaxException;

@Configuration
public class JDBCTemplate {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public JDBCTemplate() {
        dataSource = getDatasource();
        jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    public DriverManagerDataSource getDatasource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        try {
            URI dbUri = new URI("mysql://b32ab3afad4bf7:fa709e80@eu-cdbr-west-01.cleardb.com/heroku_1230023ab8a6ac8?reconnect=true");
//            URI dbUri = new URI(System.getenv("mysql://b540da1bff825c:4cf3a5c3@eu-cdbr-west-01.cleardb.com/heroku_8414b8f4e2fbcbe?reconnect=true"));
//            URI dbUri = new URI(System.getenv("CLEARDB_DATABASE_URL"));
            String username = dbUri.getUserInfo().split(":")[0];
            String password = dbUri.getUserInfo().split(":")[1];
            String dbUrl = "jdbc:mysql://" + dbUri.getHost() + dbUri.getPath();
            dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
            dataSource.setPassword(password);
            dataSource.setUrl(dbUrl);
            dataSource.setUsername(username);
            return dataSource;
        } catch(URISyntaxException e) {
            System.err.println("Unable to create host URI");
            e.printStackTrace();
            return null;
        }
    }

    public String registerUser(User user) {
        if (isUsernameFree(user.getUserName()) && passwordCheck(user)) {
            String SQL = "insert into users (email, firstname, lastName, role, userName, password) values (?, ?, ?, ?, ?, ?)";
            jdbcTemplateObject.update(SQL, user.getEmail(), user.getFirstName(), user.getLastName(), user.getRole(), user.getUserName(), user.getPassword());
            return "welcome";
        } else {
            return "registration";
        }
    }

    public boolean isUsernameFree(String userName) {
        for (User user : jdbcTemplateObject.query("select * from users", new UserMapper())) {
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
