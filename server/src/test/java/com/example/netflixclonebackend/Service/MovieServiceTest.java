package com.example.netflixclonebackend.Service;
import com.example.netflixclonebackend.Model.Movie;
import com.example.netflixclonebackend.Repository.MovieRepository;
import com.example.netflixclonebackend.utils.Genre;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.bytebuddy.asm.Advice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.swing.text.html.Option;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MovieServiceTest {
    @Mock
    private MovieRepository movieRepositoryMock;

    @InjectMocks
    private MovieService movieService;

    @Test
    public void getAll() {
        List<Movie> movieList = new ArrayList<Movie>();
        movieList.add(new Movie("The Godfather",
                8.175,
                16991,
                LocalDate.parse("1972-03-14"),
                "Italian-American Corleone crime family",
                "/3bhkrj58Vtu7enYsRolD1fZdja1.jpg",
                "/tmU7GeKVybMWFButWEGl2M4GeiP.jpg",
                "en",
                List.of(new Genre(18, "Drama"),new Genre(80, "Crime")),
                238L
        ));

        movieList.add(new Movie("The Science of Sleep",
                8.175,
                16991,
                LocalDate.parse("1972-03-14"),
                "Italian-American Corleone crime family",
                "/3bhkrj58Vtu7enYsRolD1fZdja1.jpg",
                "/tmU7GeKVybMWFButWEGl2M4GeiP.jpg",
                "en",
                List.of(new Genre(18, "Drama"),new Genre(80, "Crime")),
                300L
        ));

        movieList.add(new Movie("Insomnia",
                8.175,
                16991,
                LocalDate.parse("1972-03-14"),
                "Italian-American Corleone crime family",
                "/3bhkrj58Vtu7enYsRolD1fZdja1.jpg",
                "/tmU7GeKVybMWFButWEGl2M4GeiP.jpg",
                "en",
                List.of(new Genre(18, "Drama"),new Genre(80, "Crime")),
                320L
        ));


        when(movieRepositoryMock.findAll()).thenReturn(movieList);
        assertEquals(3, movieService.getAllMovies("trending").get("results"), "");

    }

    @Test
    public void getByGenre() {
        String genre = "trending";
        Map<String, Object> movieMap = null;
       Object fetchedData = new Object();
        when(movieRepositoryMock.findByGenre(genre)).thenReturn(movieMap);
        assertEquals(20, movieService.getAllMovies(genre).get("results").size(), "");
    }


//    @Test
//    public void getMovie() {
//        Movie movie = new Movie(
//                "The Godfather",
//                8.175,
//                16991,
//                LocalDate.parse("1972-03-14"),
//                "Italian-American Corleone crime family",
//                "/3bhkrj58Vtu7enYsRolD1fZdja1.jpg",
//                "/tmU7GeKVybMWFButWEGl2M4GeiP.jpg",
//                "en",
//                List.of(new Genre(18, "Drama"),new Genre(80, "Crime")),
//                238L
//        );
//        when(movieRepositoryMock.findById(movie.getId())).thenReturn(Optional.of(movie));
//        assertEquals(movie, movieService.getOneMovie(movie.getId()));
//    }

}
