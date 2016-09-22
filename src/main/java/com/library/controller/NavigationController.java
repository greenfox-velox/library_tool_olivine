package com.library.controller;

import com.library.requests.book.BookRequests;
import com.library.requests.borrowing.BorrowingRequests;
import com.library.requests.user.UserRequests;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;

import static com.library.controller.MVObjectHandler.addToEachModelAndView;

@Controller
public class NavigationController {

    @Autowired
    BookRequests bookRequest;

    @Autowired
    UserRequests userRequest;

    @Autowired
    BorrowingRequests borrowingRequest;

    @RequestMapping(value = "books", method= RequestMethod.GET)
    public ModelAndView books(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("books", (bookRequest.listAllBooks()).books);
        addToEachModelAndView(modelAndView);
        modelAndView.setViewName("authorized/books");
        return modelAndView;
    }

    @RequestMapping(value = "users", method= RequestMethod.GET)
    public ModelAndView users() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("users", (userRequest.getAllUsers()).users);
        addToEachModelAndView(modelAndView);
        modelAndView.setViewName("authorized/users");
        return modelAndView;
    }

    @RequestMapping(value = "borrowings", method= RequestMethod.GET)
    public ModelAndView borrowings(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("borrowings", (borrowingRequest.getAllBorrowings()).borrowings);
        addToEachModelAndView(modelAndView);
        modelAndView.setViewName("authorized/borrowings");
        return modelAndView;
    }

}
