package com.project1.simpleWebApp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping("/")
    public String home() {
        return "This is the home page!";
    }

    @RequestMapping("/about")
    public String about() {
        return "This is the about page!";
    }

}
