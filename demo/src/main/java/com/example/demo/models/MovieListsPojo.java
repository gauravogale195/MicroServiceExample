package com.example.demo.models;

import java.util.List;

public class MovieListsPojo {

	private List<String> movieList;

	public MovieListsPojo() {
		// TODO Auto-generated constructor stub
	}
	

	public MovieListsPojo(List<String> movieList) {
		super();
		this.movieList = movieList;
	}


	public List<String> getMovieList() {
		return movieList;
	}

	public void setMovieList(List<String> movieList) {
		this.movieList = movieList;
	}

}
