package com.library.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;
import java.util.Date;

/**
 * Created by Attila on 16/08/2016.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Autowired
    public void configAuth(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
            .usersByUsernameQuery("SELECT userName, password, 1 from users where userName=?")
            .authoritiesByUsernameQuery("SELECT userName, role FROM users WHERE userName = ?");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .formLogin()
            .loginPage("/login")
            .failureUrl("/login?error")
            .usernameParameter("userName")
            .passwordParameter("password")
            .and()
            .logout()
            .logoutSuccessUrl("/login?logout")
            .and()
            .csrf();
    }
}

