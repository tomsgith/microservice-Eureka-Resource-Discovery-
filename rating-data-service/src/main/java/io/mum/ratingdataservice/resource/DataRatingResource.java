package io.mum.ratingdataservice.resource;

import io.mum.ratingdataservice.model.Rating;
import io.mum.ratingdataservice.model.UserRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratingsdata")
public class DataRatingResource {
    @RequestMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") String movieId){

        return new Rating("23",6);
    }
    @RequestMapping("users/{userId}")
    public UserRating getUserRating(@PathVariable("userId") String movieId){

        List<Rating> ratings= Arrays.asList(
                new Rating("32",3),
                new Rating("65",5)
        );
        return new UserRating(ratings);
    }

}
