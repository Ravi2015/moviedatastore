package com.example.moviedatastore.service;

import com.example.moviedatastore.dto.MovieData;
import com.example.moviedatastore.dto.SearchRequest;
import com.example.moviedatastore.repository.CastMemberEntity;
import com.example.moviedatastore.repository.GenreEntity;
import com.example.moviedatastore.repository.MovieDataEntity;
import com.example.moviedatastore.repository.MovieDataRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchService {

    private final MovieDataRepository movieDataRepository;

    public SearchService(MovieDataRepository movieDataRepository) {
        this.movieDataRepository = movieDataRepository;
    }

    public List<MovieData> getMovieData(SearchRequest request){
        MovieDataEntity movieDataEntity = new MovieDataEntity();
        movieDataEntity.setTitle(request.getTitle());
        movieDataEntity.setMovieYear(request.getYear()>0?Integer.toString(request.getYear()):null);
        GenreEntity genreEntity = new GenreEntity();
        genreEntity.setGenre(request.getGenre());
        movieDataEntity.setGenres(List.of(genreEntity));
        CastMemberEntity castMemberEntity = new CastMemberEntity();
        castMemberEntity.setCastMemberName(request.getCastMember());
        movieDataEntity.setCastMembers(List.of(castMemberEntity));
        ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreNullValues();
        List<MovieDataEntity> movieDataEntities = movieDataRepository.findAll(Example.of(movieDataEntity, matcher));
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
