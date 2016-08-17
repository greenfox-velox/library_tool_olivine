package com.library.controller;

import com.library.userRequests.*;
//import unused.validator.Validator;
import com.library.model.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class RegController {

    private static final Logger logger = Logger.getLogger(RegController.class);

    @Autowired
    userRequests ur;

    @RequestMapping(value="/registration", method=RequestMethod.GET)
    public ModelAndView registrationForm() {
        logger.info("Registration page loaded");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", new User());
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @RequestMapping(value="/registration", method=RequestMethod.POST)
    public ModelAndView regSubmit(@Valid @ModelAttribute("user") User user, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView();
        boolean userIsValid = ur.registerUser(user);
        ur.resultHasErrors(result);
        if (!userIsValid) {
            logger.error("Something went wrong (invalid userName, f*cker!)");
            modelAndView.setViewName("registration");
        } else {
            logger.info("Navigated to Welcome site");
            modelAndView.setViewName("welcome");
        }
        return modelAndView;
    }


}
