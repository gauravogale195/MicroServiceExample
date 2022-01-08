package com.go.catalog.model;

public class Ratings {

	private String movie;
	private double ratings;
	
	public Ratings() {
		// TODO Auto-generated constructor stub
	}

	public Ratings(String movie, double ratings) {
		super();
		this.movie = movie;
		this.ratings = ratings;
	}

	public String getMovie() {
		return movie;
	}

	public void setMovie(String movie) {
		this.movie = movie;
	}

	public double getRatings() {
		return ratings;
	}

	public void setRatings(double ratings) {
		this.ratings = ratings;
	}
	
}
