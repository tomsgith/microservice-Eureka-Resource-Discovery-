package io.mum.ratingdataservice.model;

public class Rating {
    private String movieId;
    private int ratings;

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
