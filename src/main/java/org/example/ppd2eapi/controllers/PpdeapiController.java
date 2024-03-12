package org.example.ppd2eapi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public record PpdeapiController() {
    @GetMapping({"/", " "})
    public String homePage() {
        return "index";
    }
}
