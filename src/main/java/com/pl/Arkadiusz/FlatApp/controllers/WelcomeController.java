package com.pl.Arkadiusz.FlatApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class WelcomeController {
    @GetMapping
    public String getWelcomePage() {

        return "welcome-page";
    }
}