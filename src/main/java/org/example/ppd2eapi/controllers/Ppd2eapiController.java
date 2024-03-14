package org.example.ppd2eapi.controllers;

import org.example.ppd2eapi.models.Movie;
import org.example.ppd2eapi.models.User;
import org.example.ppd2eapi.services.MovieService;
import org.example.ppd2eapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller
public class Ppd2eapiController {

    // dependencies
    private final UserService userService;
    private final MovieService movieService;

    private boolean queryTrigger = false;

    @Autowired
    public Ppd2eapiController(UserService userService, MovieService movieService) {
        this.userService = userService;
        this.movieService = movieService;
    }


    @GetMapping({"/", " ", "/home"})
    public String homePage() {
        this.queryTrigger = false;
        return "index";
    }

    @PostMapping("/home")
    public String error(@RequestParam(required = false, defaultValue = "") boolean error, Model model) {
        model.addAttribute("error", error);
        return "index";
    }

    @GetMapping("/register")
    public String register(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/add-user")
    public String addUser(@ModelAttribute User user) {
        userService.addUser(user);
        return "redirect:/home";
    }

    @GetMapping("/search")
    public String search(Model model) {
        model.addAttribute("myMovies", movieService.getMyMovies());
        model.addAttribute("queryTrigger", this.queryTrigger);
        return "search";
    }

    @GetMapping("/search-movie")
    public String searchMovies(@RequestParam(required = false, defaultValue = "") String query, Model model) {
        this.queryTrigger = true;
        List<Movie> myMovies = movieService.findByTitle(query);
        model.addAttribute("queryTrigger", this.queryTrigger);
        model.addAttribute("myMovies", myMovies);
        return "search";
    }

}
