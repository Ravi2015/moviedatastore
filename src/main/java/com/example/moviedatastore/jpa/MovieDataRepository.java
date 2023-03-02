package com.example.moviedatastore.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface MovieDataRepository extends JpaRepository<MovieDataEntity, String> {

    List<MovieDataEntity> findAllByMovieYear(String value);

}
