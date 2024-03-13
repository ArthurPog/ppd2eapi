package org.example.ppd2eapi.services;

import org.example.ppd2eapi.models.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> findAll();
    void save(Movie movie);

    List<Movie> getMyMovies();
    List<Movie> findByTitle(String title);
}
