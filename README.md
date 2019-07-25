# Movie Score Provider Practice project for Microservices
Implementation of microservices in Spring Boot for a movie score provider service. Implementation of best practices to follow while designing microservices which communicate with each other.
1) It has 3 services. movie-catalog-service, movie-info-service and ratings-data-service. 
2) movie-catalog-service communicates w ith two of the other services to provides the score for the movieId provided through      JSON request.
3) Use of Service Discovery Pattern using netflix Eureka. Using client side load balancing with a intermediary Eureka Server.
4) Use of netflix hystrix to design circuit breaker for the services which are consumed by movie-catalog-service.
5) Used an external web service from moviedb.org to get the movie data in the movie-info-service.
