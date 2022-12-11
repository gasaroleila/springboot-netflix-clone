package com.example.netflixclonebackend.Repository;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import static org.mockito.Mockito.when;

public class MovieRepositoryTest {
    @Autowired
    private MovieRepository movieRepository;

    @Test
    public void getMoviesByGenre() {
        String genre = "trending";
        RestTemplate api = new RestTemplate();
        String url = "https://api.themoviedb.org/3";
        String path ="";
//        when(api.getForObject(url+path+"&page=5",String.class)).thenReturn();
    }
}
