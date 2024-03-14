package org.example.ppd2eapi.services.implementations;

import org.example.ppd2eapi.models.DTOs.MovieDTO;
import org.example.ppd2eapi.models.DTOs.MovieResponseDTO;
import org.example.ppd2eapi.models.Movie;
import org.example.ppd2eapi.repositories.MovieRepo;
import org.example.ppd2eapi.services.MovieAPI;
import org.example.ppd2eapi.services.MovieService;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceImp implements MovieService {
    List<Movie> myMovies;

    private Retrofit retrofit;
    private MovieAPI movieAPI;

    private final String key = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJkMjgyMWU1NTMzNWM5NjI2ZDkzMTkyNmVmMThjYzdmMyIsInN1YiI6IjU4ZTliZDhmOTI1MTQxNGIyODAyOWYxMCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.TPUbd5lK-AsfrBp8c7E82KP55L0f2wptT_F65qaRmwY";
    private final String acceptValue = "application/json";

    // dependencies
    private final MovieRepo movieRepo;

    public MovieServiceImp(MovieRepo movieRepo) {
        this.movieRepo = movieRepo;
        this.myMovies = new ArrayList<>();
        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/search/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        movieAPI = retrofit.create(MovieAPI.class);
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

    @Override
    public MovieResponseDTO getMovies(String title) {
        List<Movie> moviesFromDB = movieRepo.findAllByTitleContainingIgnoreCase(title);
        if (moviesFromDB.isEmpty()) {
            Call<MovieResponseDTO> sendRequest = movieAPI.fetchMovies(title, acceptValue, key);
            MovieResponseDTO result = null;

        /* statements for testing it works
        System.out.println(fetchData.toString());
        // Print the request URL
        System.out.println("Request URL: " + fetchData.request().url());
        // Print the request headers
        Headers headers = fetchData.request().headers();
        for (int i = 0, size = headers.size(); i < size; i++) {
            System.out.println(headers.name(i) + ": " + headers.value(i));
        }
        */

            try {
                Response<MovieResponseDTO> tryFetchData = sendRequest.execute();
                if (tryFetchData.isSuccessful() && tryFetchData.body() != null) {
                    System.out.println(tryFetchData.body());
                    result = tryFetchData.body();
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            // save it into DB
            for (MovieDTO movieDTO : result.getResults()){
                movieRepo.save(new Movie(movieDTO));
            }

            return result;
        } else {
            // there should be some way to make it more simple
            MovieResponseDTO movieResponseDTO = new MovieResponseDTO();
            for (Movie movie : moviesFromDB){
                movieResponseDTO.add(new MovieDTO(movie));
            }
            return movieResponseDTO;
        }
    }

    public void setMyMovies(List<Movie> myMovies) {
        this.myMovies = myMovies;
    }

}
