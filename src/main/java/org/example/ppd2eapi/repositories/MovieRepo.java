package org.example.ppd2eapi.repositories;

import org.example.ppd2eapi.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepo extends JpaRepository<Movie, Long> {
    List<Movie> findAllByTitleContainingIgnoreCase(String query);
}
