package com.example.netflixclonebackend.Repository;

import com.example.netflixclonebackend.Model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    Map findByGenre(String genre);

    Map findMovieById(Long id, String media_type);
}
