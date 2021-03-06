package com.pl.Arkadiusz.FlatApp.controllers;

import com.pl.Arkadiusz.FlatApp.dto.RegisterUSerDto;
import com.pl.Arkadiusz.FlatApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/register")
public class RegistrationController {
    private final UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute(name = "flatNumbers", binding = false)
    public List<String> flatNumbers() {
        return Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11");
    }

    @GetMapping
    public String prepareRegistrationPage(@ModelAttribute("UserRegistration") RegisterUSerDto userDto) {
        return "register-form";
    }


    @PostMapping
    public String processRegistrationPage(@Valid @ModelAttribute("UserRegistration")  RegisterUSerDto userDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "register-form";
        }
        try {
            userService.saveUser(userDTO);
        } catch (Exception d) {
            d.printStackTrace();
            return "redirect:/register";
        }
        return "login-page";
    }


}
