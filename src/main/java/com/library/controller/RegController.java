package com.library.controller;

import com.library.model.business.User;
import com.library.requests.user.UserRequests;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    UserRequests userRequest;

    @RequestMapping(value="/registration", method=RequestMethod.GET)
    public ModelAndView registrationForm() {
        logger.info("Registration page loaded");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", new User());
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @RequestMapping(value="/registration", method=RequestMethod.POST)
    public String regSubmit(@Valid @ModelAttribute("user") User user, BindingResult result) {
        userRequest.validate(user, result);
        if (result.hasErrors()) {
            return "registration";
        } else {
            userRequest.registerUser(user);
            return "redirect:/login";
        }
    }

}
