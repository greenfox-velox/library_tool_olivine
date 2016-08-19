package com.library.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Attila on 16/08/2016.
 */
@Controller
public class LoginController {

    private static final Logger logger = Logger.getLogger(RegController.class);

    @RequestMapping(value = {"/login", "/"}, method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        logger.info("Login page loaded");
        return modelAndView;
    }

    @RequestMapping(value = "/welcome")
    public ModelAndView hello() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("hello");
        logger.info("Welcome page loaded");
        return modelAndView;
    }

}
