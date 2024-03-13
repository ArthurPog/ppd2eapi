package org.example.ppd2eapi.services.implementations;

import org.example.ppd2eapi.models.Movie;
import org.example.ppd2eapi.repositories.MovieRepo;
import org.example.ppd2eapi.services.MovieService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceImp implements MovieService {
    List<Movie> myMovies;


    // dependencies
    private final MovieRepo movieRepo;

    public MovieServiceImp(MovieRepo movieRepo) {
        this.movieRepo = movieRepo;
        this.myMovies = new ArrayList<>();
    }

    // methods
    @Override
    public List<Movie> findAll() {
        return movieRepo.findAll();
    }

    @Override
    public void save(Movie movie) {
        movieRepo.save(movie);
    }

    public List<Movie> getMyMovies() {
        return myMovies;
    }

    @Override
    public List<Movie> findByTitle(String title) {
        return movieRepo.findAllByTitleContainingIgnoreCase(title);
    }

    public void setMyMovies(List<Movie> myMovies) {
        this.myMovies = myMovies;
    }
}
