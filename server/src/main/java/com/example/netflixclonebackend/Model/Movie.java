package com.example.netflixclonebackend.Model;

import com.example.netflixclonebackend.utils.Genre;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

//{
//    id: 111551,
//    title: 'Haireta mou ton Platano',
//    rating: 6.3,
//    overview: "The small Greek village of Platanos (Plane Tree) buries the elderly recluse Vangelas and notifies the deceased's estranged children and grandchildren about his death. Vangela's will leaves 3 million euros to his family, but requires them to move to the village and obey certain terms in order to inherit.",
//    poster: 'https://image.tmdb.org/t/p/w500/vAu6or1W4G1q7wJxQfDmATtnIg.jpg',
//    banner: 'https://image.tmdb.org/t/p/original/1vgdmeW6keP47DQ1tGwfVCdUKqu.jpg',
//    genre: [ {id: 1234, name:"Drama"} ]
//  }
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String title;
    private double vote_average;
    private double vote_count;
    private LocalDate release_date;

    private String overview;
    private String poster_path;
    private String backdrop_path;
    private String original_language;

    @Transient
    private List<Genre> genres;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Movie() {
    }

    public Movie(String title, double vote_average, double vote_count, LocalDate release_date, String overview, String poster_path, String backdrop_path, String original_language, List<Genre> genre, Long id) {
        this.title = title;
        this.vote_average = vote_average;
        this.vote_count = vote_count;
        this.release_date = release_date;
        this.overview = overview;
        this.poster_path = poster_path;
        this.backdrop_path = backdrop_path;
        this.original_language = original_language;
        this.genres = genre;
        this.id = id;
    }

    public Movie(String title, double vote_average, double vote_count, LocalDate release_date, String overview, String poster_path, String backdrop_path, String original_language, List<Genre> genre) {
        this.title = title;
        this.vote_average = vote_average;
        this.vote_count = vote_count;
        this.release_date = release_date;
        this.overview = overview;
        this.poster_path = poster_path;
        this.backdrop_path = backdrop_path;
        this.original_language = original_language;
        this.genres = genre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getVote_average() {
        return vote_average;
    }

    public void setVote_average(Float vote_average) {
        this.vote_average = vote_average;
    }

    public double getVote_count() {
        return vote_count;
    }

    public void setVote_count(Float vote_count) {
        this.vote_count = vote_count;
    }

    public LocalDate getRelease_date() {
        return release_date;
    }

    public void setRelease_date(LocalDate release_date) {
        this.release_date = release_date;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genre) {
        this.genres = genre;
    }

}