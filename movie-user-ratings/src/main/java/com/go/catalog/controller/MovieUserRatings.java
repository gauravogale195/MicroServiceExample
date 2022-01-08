package com.go.catalog.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.go.catalog.model.MovieListsPojo;
import com.go.catalog.model.Ratings;
import com.go.catalog.model.UserRatings;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@RestController
@RequestMapping("/userratings")
public class MovieUserRatings {

	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	UserRatings userRatings;
	
	@Autowired
	EurekaClient discoveryClient;
	
	public String serviceUrl() {
	    InstanceInfo instance = discoveryClient.getNextServerFromEureka("MOVIES", false);
	    return instance.getHomePageUrl();
	}
	
	@GetMapping
	public UserRatings getUserMovieRatings() {
		String url = serviceUrl();
		MovieListsPojo movies = restTemplate.getForObject("http://MOVIES/movies", MovieListsPojo.class);
		HashMap<String, Double> ratingsMap = new HashMap<>();
		movies.getMovieList().forEach(movie ->{
			Ratings ratings=restTemplate.getForObject("http://MOVIERATINGS/ratings/" + movie, Ratings.class);
			ratingsMap.put(movie, ratings.getRatings());
		});
		return new UserRatings(ratingsMap);
	}
}
