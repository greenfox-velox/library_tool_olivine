package com.library.controller;

import com.library.model.business.User;
import com.library.requests.user.UserRequests;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import static com.library.controller.MVObjectHandler.addToEachModelAndView;

@Controller
public class EditController {

    @Autowired
    UserRequests userRequest;

    @RequestMapping(value="/edit/user/{id}", method= RequestMethod.GET)
    public ModelAndView editUserForm(@PathVariable("id") Integer user_id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userToEdit", userRequest.getUserById(user_id));
        addToEachModelAndView(modelAndView);
        modelAndView.setViewName("/authorized/edit/user");
        return modelAndView;
    }


}
