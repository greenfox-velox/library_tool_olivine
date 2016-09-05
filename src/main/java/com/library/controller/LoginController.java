package com.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

import static com.library.securityUtil.SecurityUtil.hasRole;

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
        System.out.println(request.getUserPrincipal());
        ModelAndView modelAndView = new ModelAndView();
        if (hasRole("user")) {
            modelAndView.setViewName("userLanding");
        }else if (hasRole("admin")) {
            modelAndView.setViewName("adminLanding");
        }
        return modelAndView;
    }

}
//
//    public String successFulLogin() {
//        if (validation.hasRole("ADMIN")) {
//            return "redirect:/admin";
//        }
//        else {
//            return "redirect:/user";
//        }
//    }
//}
