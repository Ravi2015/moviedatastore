package com.example.moviedatastore.repository;

import org.springframework.data.jpa.repository.JpaRepository;


public interface MovieDataRepository extends JpaRepository<MovieDataEntity, String> {

}
