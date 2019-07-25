package io.practice.ratingsdataservice.models;

import java.util.List;

public class UserRatings {
	private String id;
	private List<MovieRating> userRating;
	
	public UserRatings() {

	}

	public UserRatings(String id,List<MovieRating> userRating) {
		super();
		this.id=id;
		this.userRating = userRating;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<MovieRating> getUserRating() {
		return userRating;
	}

	public void setUserRating(List<MovieRating> userRating) {
		this.userRating = userRating;
	}
	

}
