package com.library.controller;

import com.library.JDBCTemplate;
import com.library.validator.Validator;
import com.library.user.User;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class libController {

    private static final Logger logger = Logger.getLogger(libController.class);


    public JDBCTemplate myTemplate = new JDBCTemplate();
    Validator validator = new Validator();

    @RequestMapping(value="/registration", method=RequestMethod.GET)
    public String registrationForm(Model model) {
        logger.info("Registration page loaded");
        model.addAttribute("user", new User());
        return "registration";
    }

    @RequestMapping(value="/registration", method=RequestMethod.POST)
    public String regSubmit(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            logger.error("Something went wrong");
            return "registration";
        } else {
            logger.info("Navigated to Welcome site");
            return validator.registrationValidation(user);
        }
    }

}
