package com.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

import static com.library.controller.MVObjectHandler.addToEachModelAndView;
import static com.library.securityUtil.SecurityUtil.hasRole;
import static com.library.securityUtil.SecurityUtil.returnRole;

@Controller
public class LoginController {

    @RequestMapping(value = {"/login", "/"}, method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(value = "/welcome")
    public ModelAndView hello(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        if (hasRole("user")) {
            modelAndView.setViewName("authorized/user/userWelcome");
            addToEachModelAndView(modelAndView);
        }else if (hasRole("admin")) {
            modelAndView.setViewName("authorized/admin/adminWelcome");
            addToEachModelAndView(modelAndView);
        }
        return modelAndView;
    }

}

