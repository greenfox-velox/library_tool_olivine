package com.library.controller;

import com.library.requests.book.BookRequests;
import com.library.requests.user.UserRequests;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;

@Controller
public class NavigationController {

    @Autowired
    BookRequests bookRequest;

    @RequestMapping(value = "books", method= RequestMethod.GET)
    public ModelAndView books(HttpServletRequest request) {
//        System.out.println(request.getUserPrincipal());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("books", (bookRequest.listAllBooks()).books);
        modelAndView.setViewName("authorized/books");
        return modelAndView;
    }

}
