package com.cs544.controller;

import com.cs544.service.CourseofferingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @RequestMapping(value = "/")
    public String locations(){
        return "main";

    }

    @Autowired
    CourseofferingService courseofferingService;

/*    @RequestMapping(value = "/")
    public ModelAndView index () {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
}*/


}
