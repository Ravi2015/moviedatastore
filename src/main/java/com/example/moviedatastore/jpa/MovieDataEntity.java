package com.example.moviedatastore.jpa;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="T_MOVIE_DATA")
public class MovieDataEntity {

    @Id
    private String title;
    private String movieYear;
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<CastMemberEntity> castMembers;
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
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

    @Override
    public String toString() {
        return "MovieDataEntity{" +
                "title='" + title + '\'' +
                ", movieYear='" + movieYear + '\'' +
                ", castMembers=" + castMembers +
                ", genres=" + genres +
                '}';
    }
}
