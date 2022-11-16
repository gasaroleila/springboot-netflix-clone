package com.example.netflixclonebackend.Model;

import com.example.netflixclonebackend.utils.Genre;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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

    private String title;
    private Float rating;
    private String overview;
    private String poster;
    private String banner;

    private List<Genre> genre;
    private Long id;

    public Movie() {};

    public Movie(String title, Float rating, String overview, String poster, String banner, List<Genre> genre) {
        this.title = title;
        this.rating = rating;
        this.overview = overview;
        this.poster = poster;
        this.banner = banner;
        this.genre = genre;
    }


    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }


    public List<Genre> getGenre() {
        return genre;
    }

    public void setGenre(List<Genre> genre) {
        this.genre = genre;
    }
}
