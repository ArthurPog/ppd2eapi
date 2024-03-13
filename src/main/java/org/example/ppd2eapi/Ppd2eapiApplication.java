package org.example.ppd2eapi;

import org.example.ppd2eapi.services.MovieService;
import org.example.ppd2eapi.services.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Ppd2eapiApplication {

    // dependencies
    private final UserService userService;
    private final MovieService movieService;

    public Ppd2eapiApplication(UserService userService, MovieService movieService) {
        this.userService = userService;
        this.movieService = movieService;
    }

    public static void main(String[] args) {
        SpringApplication.run(Ppd2eapiApplication.class, args);
    }

}
