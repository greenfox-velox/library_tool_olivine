package com.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/", "/home", "/registration", "/users").permitAll()
                .anyRequest()
                .authenticated()
                .and()
            .formLogin()
                .loginPage("/login").permitAll()
                .usernameParameter("userName")
                .passwordParameter("password")
                .defaultSuccessUrl("/hello", true)
                .permitAll()
                .and()
            .logout()
                .permitAll();
    }


    @Autowired
    DataSource dataSource;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
            .dataSource(dataSource)
            .withDefaultSchema()
            .withUser("Miki12").password("123456");
//            .usersByUsernameQuery("select userName, password from users where userName = ?");
//            .authoritiesByUsernameQuery("select username, role from users where userName=?");
    }
}
