package org.example.ppd2eapi.models.DTOs;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.ppd2eapi.models.Movie;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDTO {

    private Long id;
    private String title;
    @SerializedName("release_date")
    private String releaseDate;
    private String overview;

    public MovieDTO(Movie movie) {
        this.id = movie.getId();
        this.title = movie.getTitle();
        this.releaseDate = movie.getReleaseDate();
        this.overview = movie.getOverview();
    }
}
