package io.practice.ratingsdataservice.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.practice.ratingsdataservice.models.MovieRating;
import io.practice.ratingsdataservice.models.UserRatings;

@RestController
@RequestMapping("movies")
public class MovieRatingsResource {
	
	@RequestMapping("/{movieId}")
	public MovieRating getMovieRating(@PathVariable String movieId) {
		return new MovieRating(movieId,"4");
	}
	
	@RequestMapping("users/{userId}")
	public UserRatings getRatings(@PathVariable String userId) {
		List<MovieRating> ratings=new ArrayList<MovieRating>() {{add(new MovieRating("100","4"));
		add(new MovieRating("200","3"));
		}};
		UserRatings userRatings=new UserRatings(userId,ratings);
		return userRatings;
	}

}
