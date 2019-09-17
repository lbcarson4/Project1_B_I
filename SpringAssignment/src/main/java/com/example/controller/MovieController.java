package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Movie;
import com.example.repository.MovieDao;

@RestController
@Component
public class MovieController {

	@Autowired
	private MovieDao movieDao;

	public MovieController() {
		super();
	}
	
	@GetMapping(value = "/getAllShowtimes.do")
	public List<Movie> getAllMovies() {
		return movieDao.selectAll();
	}
	
	@GetMapping(value = "{name}/getMovie.do")
	public Movie getMovieByName(@PathVariable("name") String name) {
		return movieDao.selectByName(name);
	}
	
}
