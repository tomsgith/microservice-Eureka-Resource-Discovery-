package io.mum.moviecatalogservice.model;

public class Rating {
    private String movieId;
    private int ratings;

    public Rating(){}

    public Rating(String movieId, int ratings) {
        this.movieId = movieId;
        this.ratings = ratings;
    }

    public String getMovieId() {
        return movieId;
    }

    public int getRatings() {
        return ratings;
    }
}
