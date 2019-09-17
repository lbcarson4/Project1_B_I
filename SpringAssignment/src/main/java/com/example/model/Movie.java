package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MOVIE")
public class Movie {
	
	@Id
	@Column(name = "movie_name")
	private String movieName;
	
	@Column(name = "rating", nullable = false)
	private String rating;
	
	@Column(name = "show_times")
	private String showTimes;

	public Movie() {
		super();
	}

	public Movie(String movieName, String rating, String showTimes) {
		super();
		this.movieName = movieName;
		this.rating = rating;
		this.showTimes = showTimes;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getShowTimes() {
		return showTimes;
	}

	public void setShowTimes(String showTimes) {
		this.showTimes = showTimes;
	}

	@Override
	public String toString() {
		return "Movie [movieName=" + movieName + ", rating=" + rating + ", showTimes="
				+ showTimes + "]";
	}
}
