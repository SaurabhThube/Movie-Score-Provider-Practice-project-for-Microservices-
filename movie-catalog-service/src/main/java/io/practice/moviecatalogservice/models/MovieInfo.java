package io.practice.moviecatalogservice.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class MovieInfo {
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	@HystrixCommand(fallbackMethod = "getFallBackCatalogItem")
	public CatalogItem getCatalogItem(MovieRating rating) {
		Movie movie=restTemplate.
				getForObject("http://movie-info-service/movies/"+rating.getMovieId(), Movie.class);
				return new CatalogItem(movie.getName(),movie.getDesc(),rating.getRating());
	}
	
	
	public CatalogItem getFallBackCatalogItem(MovieRating rating) {
		return new CatalogItem("Movie name not found","",rating.getRating());
		}

}
