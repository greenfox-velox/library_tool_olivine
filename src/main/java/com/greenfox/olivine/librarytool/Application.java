package com.greenfox.olivine.librarytool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void uj(){
        System.out.println("hello");
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
