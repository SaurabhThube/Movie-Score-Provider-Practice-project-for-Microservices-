package io.practice.moviecatalogservice.models;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class UserRatingInfo {

	
	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "getFallBackUserRatings")
	public UserRatings getUserRatings(String userId) {
		return restTemplate.getForObject("http://movie-ratings-service/movies/users/"+userId, UserRatings.class);
	}
	


	
	public UserRatings getFallBackUserRatings(String userId) {
		UserRatings userRatings=new UserRatings();
		userRatings.setId(userId);
		userRatings.setUserRating(Arrays.asList(new MovieRating("0", "0")));
		return userRatings;
		
		
		}
}
