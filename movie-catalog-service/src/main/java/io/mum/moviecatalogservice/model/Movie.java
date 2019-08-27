package io.mum.moviecatalogservice.model;

public class Movie {
    private String movieId;
    private String name;

    public Movie(){

    }
    public Movie(String movieId, String name) {
        this.movieId = movieId;
        this.name = name;
    }

    public String getMovieId() {
        return movieId;
    }

    public String getName() {
        return name;
    }
}
