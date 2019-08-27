package io.mum.moviecatalogservice.resources;


import io.mum.moviecatalogservice.model.CatalogItem;
import io.mum.moviecatalogservice.model.Movie;
import io.mum.moviecatalogservice.model.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @Autowired
    private RestTemplate restTemplate;

    private DiscoveryClient discoveryClient;



    //    @Autowired
//    private WebClient.Builder webClientBuilder;
    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
        UserRating ratings= restTemplate.getForObject("http://RATING-DATA-SERVICE/ratingsdata/users/"+userId,
                UserRating.class);
        return ratings.getUserRatings().stream()
                .map(rat->
                {
                 //1.get all related movie ids
                    Movie movie=restTemplate.getForObject("http://MOVIE-INFO-SERVICE/movies/"+rat.getMovieId(), Movie.class);
                 //2.For each movie id,call movie info service and get details
                    return   new CatalogItem(movie.getName(),"test1",4);

                })
                //3.put them all togehter
                .collect(Collectors.toList());

    }
}


//using webClient Asynchronisly
//                    Movie movie=  webClientBuilder.build()
//                           .get()
//                           .uri("http://localhost:8081/movies/"+rat.getMovieId())
//                           .retrieve()
//                           .bodyToMono(Movie.class)
//                           .block();