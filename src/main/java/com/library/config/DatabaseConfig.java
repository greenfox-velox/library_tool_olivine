package com.library.config;

import com.library.userRequests.userRequests;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * Created by Attila on 16/08/2016.
 */
@Configuration
public class DatabaseConfig {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/heroku_1230023ab8a6ac8");
        driverManagerDataSource.setUsername("root");
        driverManagerDataSource.setPassword("alma123");
        return driverManagerDataSource;
    }

    @Bean
    public userRequests userRequest() {
        return new userRequests(dataSource());
    }
}
