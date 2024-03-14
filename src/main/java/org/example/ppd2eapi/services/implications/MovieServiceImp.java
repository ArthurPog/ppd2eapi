package org.example.ppd2eapi.services.implications;

import org.example.ppd2eapi.repositories.MovieRepo;
import org.example.ppd2eapi.services.MovieService;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImp implements MovieService {

    // dependencies
    private final MovieRepo movieRepo;

    public MovieServiceImp(MovieRepo movieRepo) {
        this.movieRepo = movieRepo;
    }

    // methods
}
