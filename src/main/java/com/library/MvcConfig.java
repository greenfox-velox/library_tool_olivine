package com.library;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("login");
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/hello").setViewName("hello");
        registry.addViewController("/registration").setViewName("registration");
        registry.addViewController("/users").setViewName("users");
        registry.addViewController("/login").setViewName("login");

    }

}
