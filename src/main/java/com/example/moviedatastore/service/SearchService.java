package com.example.moviedatastore.service;

import com.example.moviedatastore.dto.MovieData;
import com.example.moviedatastore.dto.SearchRequest;
import com.example.moviedatastore.jpa.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SearchService {

    private final MovieDataRepository movieDataRepository;
    private final CastMemberRepository castMemberRepository;
    private final GenreRepository genreRepository;

    public SearchService(MovieDataRepository movieDataRepository, CastMemberRepository castMemberRepository, GenreRepository genreRepository) {

        this.movieDataRepository = movieDataRepository;
        this.castMemberRepository = castMemberRepository;
        this.genreRepository = genreRepository;
    }

    public List<MovieData> getMovieData(SearchRequest request){

        List<MovieDataEntity> movieDataEntities;

        switch (request.getSearchBy()) {
            case "title":
                Optional<MovieDataEntity> optionalMovieDataEntity = movieDataRepository.findById(request.getValue());
                if (optionalMovieDataEntity.isEmpty()){
                    movieDataEntities = List.of();
                } else {
                    movieDataEntities = List.of(optionalMovieDataEntity.get());
                }
                break;
            case "genre":
                Optional<GenreEntity> optionalGenreEntity = genreRepository.findById(request.getValue());
                if (optionalGenreEntity.isEmpty()) {
                    movieDataEntities = List.of();
                } else {
                    movieDataEntities = optionalGenreEntity.get().getMovieDataEntities();
                }
                break;
            case "castMember":
                Optional<CastMemberEntity> optionalCastMemberEntity = castMemberRepository.findById(request.getValue());
                if (optionalCastMemberEntity.isEmpty()) {
                    movieDataEntities = List.of();
                } else {
                    movieDataEntities = optionalCastMemberEntity.get().getMovieDataEntities();
                }
                break;
            case "year":
                movieDataEntities = movieDataRepository.findAllByMovieYear(request.getValue());
                break;
            default:
                movieDataEntities = List.of();
                break;
        }

        return movieDataEntities.stream()
                .map(m -> {
                    MovieData movieData = new MovieData();
                    movieData.setTitle(m.getTitle());
                    movieData.setYear(Integer.parseInt(m.getMovieYear()));
                    movieData.setGenres(m.getGenres().stream().map(g -> g.getGenre()).collect(Collectors.toList()));
                    movieData.setCast(m.getCastMembers().stream().map(c -> c.getCastMemberName()).collect(Collectors.toList()));
                    return movieData;
                })
                .collect(Collectors.toList());
    }
}
