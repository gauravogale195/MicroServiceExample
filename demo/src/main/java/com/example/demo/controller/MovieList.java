package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.MovieListsPojo;

@RequestMapping("movies")
@RestController
public class MovieList {

	@GetMapping
	public MovieListsPojo getMovies() {		
		List<String> movieList = Arrays.asList("foo","bat","bam");
		return new MovieListsPojo(movieList);
	}
}
