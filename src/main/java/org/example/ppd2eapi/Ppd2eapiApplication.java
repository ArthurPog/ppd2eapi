package org.example.ppd2eapi;

import org.example.ppd2eapi.models.Movie;
import org.example.ppd2eapi.services.MovieService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Ppd2eapiApplication implements CommandLineRunner {
    private final MovieService movieService;

    public Ppd2eapiApplication(MovieService movieService) {
        this.movieService = movieService;
    }


    public static void main(String[] args) {
        SpringApplication.run(Ppd2eapiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        movieService.save(new Movie("Shawshank Redemption"));

    }
}
