package com.example.moviedatastore.dto;


public class SearchRequest {

    private String title;
    private int year;
    private String castMember;
    private String genre;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getCastMember() {
        return castMember;
    }

    public void setCastMember(String castMember) {
        this.castMember = castMember;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}

