package com.go.catalog.model;

import java.util.HashMap;

import org.springframework.stereotype.Component;
@Component
public class UserRatings {
	private HashMap<String, Double> ratingsMap;

	public UserRatings() {
		// TODO Auto-generated constructor stub
	}

	public UserRatings(HashMap<String, Double> ratingsMap) {
		super();
		this.ratingsMap = ratingsMap;
	}

	public HashMap<String, Double> getRatingsMap() {
		return ratingsMap;
	}

	public void setRatingsMap(HashMap<String, Double> ratingsMap) {
		this.ratingsMap = ratingsMap;
	}

}
