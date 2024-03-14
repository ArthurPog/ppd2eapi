package org.example.ppd2eapi.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.ppd2eapi.models.DTOs.MovieDTO;

import java.util.Date;

@Entity
@Data
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotEmpty(message = "Must set a title!")
    private String title;
    private String releaseDate;
    private String overview;

    public Movie() {
    }
    public Movie(String title, String releaseDate, String overview) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.overview = overview;
    }
    public Movie(MovieDTO movieDTO) {
        this.id = movieDTO.getId();
        this.title = movieDTO.getTitle();
        this.releaseDate = movieDTO.getReleaseDate();
        this.overview =null;    // there is an error, that the string is actually too long for the field
    }
}