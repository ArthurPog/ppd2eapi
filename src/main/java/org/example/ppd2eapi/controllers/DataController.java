package org.example.ppd2eapi.controllers;

import org.example.ppd2eapi.models.DTOs.MovieResponseDTO;
import org.example.ppd2eapi.models.Movie;
import org.example.ppd2eapi.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/testing")
public class DataController {

    @Autowired
    private MovieService movieService;

    /*  i think that JSON load on page should be over here, but i couldn't figure it out, so i used API controller
    @GetMapping("/movie")
    public MovieResponseDTO getMoviesDTO(){
        return movieService.getMovies("shaw");
    }

    @PostMapping("/movie")
    public ResponseEntity<MovieResponseDTO> getMovies(@RequestParam(required = false, defaultValue = "") String query) {
        MovieResponseDTO movieResponseDTO = movieService.getMovies(query);
        if (movieResponseDTO.getResults().isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(movieResponseDTO);
        }
    }
    */

}
