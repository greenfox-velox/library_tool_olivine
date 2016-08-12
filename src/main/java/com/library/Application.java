package com.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.net.URISyntaxException;

@SpringBootApplication
public class Application {
//    public static void uj(){
//        System.out.println("hello");
//    }



// this is our main method which runs the application

    public static void main(String[] args) throws URISyntaxException {
        SpringApplication.run(Application.class, args);
    }
}

//package com.mkyong.common.controller;
//
//        import org.apache.log4j.Logger;
//        import org.springframework.stereotype.Controller;
//        import org.springframework.web.bind.annotation.RequestMapping;
//        import org.springframework.web.bind.annotation.RequestMethod;
//        import org.springframework.web.servlet.ModelAndView;
//
//@Controller
//public class WelcomeController {
//
//    private static final Logger logger = Logger.getLogger(WelcomeController.class);
//
//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public ModelAndView getWelcome() {
//
//        //logs debug message
//        if(logger.isDebugEnabled()){
//            logger.debug("getWelcome is executed!");
//        }
//
//        //logs exception
//        logger.error("This is Error message", new Exception("Testing"));
//
//        ModelAndView model = new ModelAndView("welcome");
//        model.addObject("msg", "Hello Spring MVC + Log4j");
//        return model;
//
//    }

