package com.example.moviedatastore.jpa;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="T_CAST_MEMBER")
public class CastMemberEntity {
    @Id
    private String castMemberName;

    @ManyToMany(mappedBy = "castMembers")
    private List<MovieDataEntity> movieDataEntities;

    public String getCastMemberName() {
        return castMemberName;
    }

    public void setCastMemberName(String castMemberName) {
        this.castMemberName = castMemberName;
    }

    public List<MovieDataEntity> getMovieDataEntities() {
        return movieDataEntities;
    }

    public void setMovieDataEntities(List<MovieDataEntity> movieDataEntities) {
        this.movieDataEntities = movieDataEntities;
    }

    @Override
    public String toString() {
        return "CastMemberEntity{" +
                "castMemberName='" + castMemberName + '\'' +
                '}';
    }
}
