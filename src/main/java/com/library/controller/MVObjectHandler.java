package com.library.controller;

import org.springframework.web.servlet.ModelAndView;

import static com.library.securityUtil.SecurityUtil.returnRole;

public class MVObjectHandler {

    public static void addToEachModelAndView(ModelAndView modelAndView) {
        modelAndView.addObject("auth", returnRole().contains("admin"));
    }

}
