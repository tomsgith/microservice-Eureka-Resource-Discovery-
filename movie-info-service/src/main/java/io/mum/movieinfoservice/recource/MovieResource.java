package io.mum.movieinfoservice.recource;

import io.mum.movieinfoservice.model.Movie;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieResource {
    @RequestMapping("/{movieId}")
    public Movie getMovie(@PathVariable("movieId") String movieId){
    return new Movie("3","Test name");
    }
}
