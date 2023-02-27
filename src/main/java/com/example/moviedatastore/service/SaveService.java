package com.example.moviedatastore.service;

import com.example.moviedatastore.dto.MovieData;
import com.example.moviedatastore.repository.CastMemberEntity;
import com.example.moviedatastore.repository.GenreEntity;
import com.example.moviedatastore.repository.MovieDataEntity;
import com.example.moviedatastore.repository.MovieDataRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SaveService {

    private final MovieDataRepository movieDataRepository;

    public SaveService(MovieDataRepository movieDataRepository) {
        this.movieDataRepository = movieDataRepository;
    }

    public boolean exists(String movieName) {
        return movieDataRepository.existsById(movieName);
    }

    public void saveMovieData(MovieData movieData) {
        MovieDataEntity movieDataEntity = new MovieDataEntity();
        movieDataEntity.setTitle(movieData.getTitle());
        movieDataEntity.setMovieYear(Integer.toString(movieData.getYear()));

        List<GenreEntity> genreEntities = movieData.getGenres().stream()
                .map(g -> {
                    GenreEntity genreEntity = new GenreEntity();
                    genreEntity.setGenre(g);
                    return genreEntity;
                }).collect(Collectors.toList());

        movieDataEntity.setGenres(genreEntities);

        List<CastMemberEntity> castMemberEntities = movieData.getCast().stream()
                .map(c -> {
                    CastMemberEntity castMemberEntity = new CastMemberEntity();
                    castMemberEntity.setCastMemberName(c);
                    return castMemberEntity;
                }).collect(Collectors.toList());

        movieDataEntity.setCastMembers(castMemberEntities);
        movieDataRepository.save(movieDataEntity);
    }
}
