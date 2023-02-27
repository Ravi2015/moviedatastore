package com.example.moviedatastore.controller;

import com.example.moviedatastore.dto.MovieData;
import com.example.moviedatastore.dto.SearchRequest;
import com.example.moviedatastore.service.SearchService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchController {

    private final SearchService searchService;

    public SearchController(SearchService searchService){
        this.searchService = searchService;
    }

    @GetMapping("v1/search")
    public List<MovieData> getMovieData(@RequestBody SearchRequest request){
        return searchService.getMovieData(request);
    }
}
