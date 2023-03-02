package com.example.moviedatastore.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name="T_GENRE")
public class GenreEntity {

    @Id
    private String genre;

    @ManyToMany(mappedBy = "genres")
    private List<MovieDataEntity> movieDataEntities;

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<MovieDataEntity> getMovieDataEntities() {
        return movieDataEntities;
    }

    public void setMovieDataEntities(List<MovieDataEntity> movieDataEntities) {
        this.movieDataEntities = movieDataEntities;
    }

    @Override
    public String toString() {
        return "GenreEntity{" +
                "genre='" + genre + '\'' +
                '}';
    }
}
