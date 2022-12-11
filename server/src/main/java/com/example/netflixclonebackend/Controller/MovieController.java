package com.example.netflixclonebackend.Controller;

import com.example.netflixclonebackend.Model.Movie;
import com.example.netflixclonebackend.Service.MovieService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

   @Autowired
   private MovieService movieService;

   @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/movies/{genre}")
    public ResponseEntity<?> getAllByGenre(@PathVariable(name="genre") String genre) {
//        List<Movie> allMovies =  movieService.getAllMovies();
//        String allMoviesJSON = new ObjectMapper().writeValueAsString(allMovies);
//        System.out.println(allMoviesJSON);
       System.out.println("server");
        return ResponseEntity.status(HttpStatus.OK).body(movieService.getAllMovies(genre));
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/movie/{id}/{mediaType}")
    public ResponseEntity<?> getById(@PathVariable(name="id") Long id, @PathVariable(name="mediaType") String media_type) {

//        Movie item = movieService.getOneMovie(id, media_type);
//        if (item != null) {
//            return ResponseEntity.ok(item);
//        }
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Movie Not Found");

        return ResponseEntity.ok(movieService.getOneMovie(id, media_type));
    }

}
