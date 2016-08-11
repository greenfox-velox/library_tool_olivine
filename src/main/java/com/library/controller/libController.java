package com.library.controller;

import com.library.JDBCTemplate.JDBCTemplate;
import com.library.user.User;
import com.library.validator.Validator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class libController {


    public JDBCTemplate myTemplate = new JDBCTemplate();
    Validator validator = new Validator();

    @RequestMapping(value="/registration", method=RequestMethod.GET)
    public String registrationForm(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @RequestMapping(value="/registration", method=RequestMethod.POST)
    public String regSubmit(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "registration";
        } else {
            return validator.registrationValidation(user);
        }
    }


}
