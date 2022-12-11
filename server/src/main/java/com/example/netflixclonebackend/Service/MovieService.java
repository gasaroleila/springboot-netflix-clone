package com.example.netflixclonebackend.Service;

import com.example.netflixclonebackend.Model.Movie;
import com.example.netflixclonebackend.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class MovieService {
   @Autowired
    private MovieRepository movieRepository;

    public Map getAllMovies(String genre) {
        return movieRepository.findByGenre(genre);
    }

    public Map getOneMovie(Long id, String media_type) {
//        Optional<Movie> findById = Optional.ofNullable(movieRepository.findMovieById(id, media_type));
//        if(findById.isPresent()) {
//            Movie movie = findById.get();
//            return movie;
//        }


        return movieRepository.findMovieById(id, media_type);
    }
}
