package com.example.moviedatastore.jpa;

import org.springframework.data.jpa.repository.JpaRepository;


public interface GenreRepository extends JpaRepository<GenreEntity, String> {
}
