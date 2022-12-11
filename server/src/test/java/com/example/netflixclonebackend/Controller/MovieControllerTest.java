package com.example.netflixclonebackend.Controller;

import com.example.netflixclonebackend.Model.Movie;
import com.example.netflixclonebackend.Service.MovieService;
import com.example.netflixclonebackend.Service.UserService;
import com.example.netflixclonebackend.utils.Genre;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = MovieController.class, excludeAutoConfiguration = {SecurityAutoConfiguration.class})
public class MovieControllerTest {
    @MockBean
    private MovieService movieServiceMock;

    @Autowired
    private MockMvc mockMvc;

//    @Test
//    public void getAll_success() throws Exception {
//        List<Movie> movieList = new ArrayList<Movie>();
//        movieList.add(new Movie("The Godfather",
//                8.175,
//                16991,
//                LocalDate.parse("1972-03-14"),
//                "Italian-American Corleone crime family",
//                "/3bhkrj58Vtu7enYsRolD1fZdja1.jpg",
//                "/tmU7GeKVybMWFButWEGl2M4GeiP.jpg",
//                "en",
//                List.of(new Genre(18, "Drama"),new Genre(80, "Crime")),
//                238L
//        ));
//
//
//        when(movieServiceMock.getAllMovies("trending")).thenReturn((Map) movieList);
//        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
//                .get("/movies/{genre}")
//                .accept(MediaType.APPLICATION_JSON);
//
//        MvcResult result = mockMvc
//                .perform(request)
//                .andExpect(status().isOk())
////                .andExpect(content().json("[" +
////                        "{\"title\":\"The Godfather\"," +
////                        "\"vote_average\":8.175," +
////                        "\"vote_count\":16991.0," +
////                        "\"release_date\":\"1972-03-14\"" +
////                        ",\"overview\":\"Italian-American Corleone crime family\"," +
////                        "\"poster_path\":\"/3bhkrj58Vtu7enYsRolD1fZdja1.jpg\"," +
////                        "\"backdrop_path\":\"/tmU7GeKVybMWFButWEGl2M4GeiP.jpg\"," +
////                        "\"original_language\":\"/en\"," +
////                        "\"genres\":[{\"id\":18,\"name\":\"Drama\"},{\"id\":80,\"name\":\"Crime\"}],\"id\":238}],"+
////                        "\"id\":230" +
////                        "}]"))
//                .andReturn();
//    }


    @Test
    public void getMovie() throws Exception {
        Movie movie= new Movie("The Godfather",
                8.175,
                16991,
                LocalDate.parse("1972-03-14"),
                "Italian-American Corleone crime family",
                "/3bhkrj58Vtu7enYsRolD1fZdja1.jpg",
                "/tmU7GeKVybMWFButWEGl2M4GeiP.jpg",
                "en",
                List.of(new Genre(18, "Drama"),new Genre(80, "Crime")),
                238L
        );

        when(movieServiceMock.getOneMovie(movie.getId(), "tv")).thenReturn((Map) movie);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get("/movies/238")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc
                .perform(request)
                .andExpect(status().is2xxSuccessful())
                .andReturn();

    }

}
