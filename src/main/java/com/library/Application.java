package com.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.net.URISyntaxException;

@SpringBootApplication
public class Application {

    public static void main(String[] args) throws URISyntaxException {
        SpringApplication.run(Application.class, args);
    }
}
