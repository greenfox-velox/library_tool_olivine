package com.library.config;

import com.library.requests.book.BookRequests;
import com.library.requests.borrowing.BorrowingRequests;
import com.library.requests.user.UserRequests;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;

@Configuration
public class DatabaseConfig {

    public HashMap<String,String> setUrlForDataSource() {
        HashMap<String,String> myUrl = new HashMap<String,String>();
        try {
            URI dbUri = new URI("mysql://root:alma123@localhost:3306/heroku_1230023ab8a6ac8");
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

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setPassword(setUrlForDataSource().get("password"));
        dataSource.setUrl(setUrlForDataSource().get("dbUrl"));
        dataSource.setUsername(setUrlForDataSource().get("username"));
        return dataSource;
    }

    @Bean
    public UserRequests userRequest() {
        return new UserRequests(dataSource());
    }

    @Bean
    public BookRequests bookRequests() { return new BookRequests(dataSource()); }

    @Bean
    public BorrowingRequests borrowingRequests() { return new BorrowingRequests(dataSource()); }
}



//            URI dbUri = new URI("mysql://b32ab3afad4bf7:fa709e80@eu-cdbr-west-01.cleardb.com/heroku_1230023ab8a6ac8");
//            URI dbUri = new URI(System.getenv("CLEARDB_DATABASE_URL"));
 /*mysql://b32ab3afad4bf7:fa709e80@eu-cdbr-west-01.cleardb.com/heroku_1230023ab8a6ac8?reconnect=true*/