package com.example.moviedatastore.repository;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="T_MOVIE_DATA")
public class MovieDataEntity {

    @Id
    private String title;
    private String movieYear;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<CastMemberEntity> castMembers;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<GenreEntity> genres;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMovieYear() {
        return movieYear;
    }

    public void setMovieYear(String year) {
        this.movieYear = year;
    }

    public List<CastMemberEntity> getCastMembers() {
        return castMembers;
    }

    public void setCastMembers(List<CastMemberEntity> castMembers) {
        this.castMembers = castMembers;
    }

    public List<GenreEntity> getGenres() {
        return genres;
    }

    public void setGenres(List<GenreEntity> genres) {
        this.genres = genres;
    }
}
