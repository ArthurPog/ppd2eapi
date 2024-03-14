package org.example.ppd2eapi.controllers;

import org.example.ppd2eapi.models.DTOs.MovieResponseDTO;
import org.example.ppd2eapi.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testing")
public class DataController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/movies/{title}")
    public MovieResponseDTO getMoviesDTO(@PathVariable String title){
        return movieService.getMovies(title);
    }


}
