package org.example.ppd2eapi.controllers;

import org.example.ppd2eapi.models.User;
import org.example.ppd2eapi.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public record PpdeapiController() {

    @GetMapping({"/", " ", "/home"})
    public String homePage() {
        return "index";
    }

    @PostMapping("/login")
    public String logIn(@ModelAttribute User user) {
        return "redirect:/search";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/add-user")
    public String addUser(@ModelAttribute User user) {
        return "redirect:/home";
    }

    @GetMapping("/search")
    public String search() {
        return "search";
    }


}
