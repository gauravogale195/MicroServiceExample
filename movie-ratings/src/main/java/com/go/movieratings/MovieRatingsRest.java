package com.go.movieratings;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.go.movieratings.pojo.Ratings;

@RestController
@RequestMapping("ratings")
public class MovieRatingsRest {

	@GetMapping("/{name}")
	public Ratings getMovieRating(@PathVariable("name") String movieName) {
		return new Ratings(movieName,Math.random());
	}
}
