package com.pl.Arkadiusz.FlatApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomePageController {

    @GetMapping
    public String showHomePage(){
        return "home-page";
    }
}
