package io.practice.moviecatalogservice.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;

import io.practice.moviecatalogservice.models.CatalogItem;
import io.practice.moviecatalogservice.models.Movie;
import io.practice.moviecatalogservice.models.MovieInfo;
import io.practice.moviecatalogservice.models.MovieRating;
import io.practice.moviecatalogservice.models.UserRatingInfo;
import io.practice.moviecatalogservice.models.UserRatings;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	MovieInfo movieInfo;
	
	@Autowired
	UserRatingInfo userRatingInfo;
	
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalogItem(@PathVariable String userId){
		
	UserRatings ratings=userRatingInfo.getUserRatings(userId);
		
		
		
		return ratings.getUserRating().stream().map(rating->movieInfo.getCatalogItem(rating)
		).
				collect(Collectors.toList());
		
		/*
		 * List<CatalogItem> list=new ArrayList<>(); list.add(new
		 * CatalogItem("PK","Funny",4)); return list;
		 */
	}




	
}
