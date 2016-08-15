package com.library;

import com.library.UserMapper;
import com.library.user.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import javax.sql.DataSource;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;

@Configuration
public class JDBCTemplate {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public JDBCTemplate() {
        dataSource = dataSource();
        jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    public HashMap<String,String> setUrlForDataSource() {
                HashMap<String,String> myUrl = new HashMap<String,String>();
                try {
                    URI dbUri = new URI(System.getenv("CLEARDB_DATABASE_URL"));
                    myUrl.put("username", dbUri.getUserInfo().split(":")[0]);
                    myUrl.put("password", dbUri.getUserInfo().split(":")[1]);
                    myUrl.put("dbUrl", "jdbc:mysql://" + dbUri.getHost() + dbUri.getPath());
                    return myUrl;
                } catch(URISyntaxException e) {
                    System.err.println("Unable to create host URI");
                    e.printStackTrace();
                    return null;
        }
    }

//    @Bean(name = "dataSource")
    public DriverManagerDataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setPassword(setUrlForDataSource().get("password"));
        dataSource.setUrl(setUrlForDataSource().get("dbUrl"));
        dataSource.setUsername(setUrlForDataSource().get("username"));
        return dataSource;
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
