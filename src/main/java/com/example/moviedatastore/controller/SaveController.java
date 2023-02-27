package com.example.moviedatastore.controller;

import com.example.moviedatastore.dto.MovieData;
import com.example.moviedatastore.service.SaveService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaveController {

    private SaveService saveService;

    public SaveController(SaveService saveService) {
        this.saveService = saveService;
    }

    @PutMapping("v1/save")
    public ResponseEntity<?> saveMovieData(@RequestBody MovieData request){
        if (saveService.exists(request.getTitle())){
            saveService.saveMovieData(request);
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
        saveService.saveMovieData(request);
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }
}
