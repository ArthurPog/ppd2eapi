package org.example.ppd2eapi.services;

import org.example.ppd2eapi.models.DTOs.MovieResponseDTO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

import java.util.List;

public interface MovieAPI {

    @GET("movie")
    Call<MovieResponseDTO> fetchMovies(@Query("query") String title, @Header("accept") String acceptValue, @Header("Authorization") String key);
}
