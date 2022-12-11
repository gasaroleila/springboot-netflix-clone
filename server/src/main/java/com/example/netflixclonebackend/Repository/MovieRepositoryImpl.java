package com.example.netflixclonebackend.Repository;

import com.example.netflixclonebackend.Model.Movie;
import com.example.netflixclonebackend.utils.ApiResult;
import com.example.netflixclonebackend.utils.ParserObj;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Component
public class MovieRepositoryImpl {
    @Autowired
    private MovieRepository movieRepository;

    @SuppressWarnings("unused")
    public Map findByGenre(String genre) throws JsonProcessingException {
        RestTemplate api = new RestTemplate();
        ObjectMapper objectMapper = new ObjectMapper();
        String url = "https://api.themoviedb.org/3";
        String path ="";

        switch (genre) {
            case "trending":
                path="/trending/all/week?api_key=8260bf8922d9bcce0924612b2add4b09&language=en-US";
                break;
            case "netflixOriginals":
                path="/discover/movie?api_key=8260bf8922d9bcce0924612b2add4b09&with_networks=213";
                break;
            case "topRated":
                path="/discover/movie?api_key=8260bf8922d9bcce0924612b2add4b09&language=en-US";
                break;
            case "actionMovies":
                path="/discover/movie?api_key=8260bf8922d9bcce0924612b2add4b09&language=en-US&with_genres=28";
                break;
            case "comedyMovies":
                path="/discover/movie?api_key=8260bf8922d9bcce0924612b2add4b09&language=en-US&with_genres=35";
                break;
            case "horrorMovies":
                path="/discover/movie?api_key=8260bf8922d9bcce0924612b2add4b09&language=en-US&with_genres=27";
                break;
            case "romanceMovies":
                path="/discover/movie?api_key=8260bf8922d9bcce0924612b2add4b09&language=en-US&with_genres=10749";
                break;

            case "documentaries":
                path="/discover/movie?api_key=8260bf8922d9bcce0924612b2add4b09&language=en-US&with_genres=99";
                break;
        }
        String data = api.getForObject(url+path+"&page=5",String.class);
        Map<String, Object> movieMap =  new ObjectMapper().readValue(data, Map.class);
        System.out.println(movieMap.get("results"));
        return movieMap;
//        System.out.println("TRENDING MOVIES"+movies.toString());
//        List<Movie> movies = Arrays.asList(objectMapper.readValue(apiResult.getResults(), Movie[].class));
    }

    public Map findMovieById(Long id, String media_type) throws JsonProcessingException {
        RestTemplate api = new RestTemplate();
        ObjectMapper objectMapper = new ObjectMapper();
        String url = "https://api.themoviedb.org/3/";
        String mediaType = "movie";

        if(Objects.equals(media_type, "tv")) {
            mediaType = "tv";
        }

        String data = api.getForObject(url+media_type+"/"+id+"?api_key=8260bf8922d9bcce0924612b2add4b09&language=en-US&append_to_response=videos",String.class);
        Map movieMap =  new ObjectMapper().readValue(data, Map.class);
        System.out.println(movieMap);
        return movieMap;
    }

}
