package com.example.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Movie;

@Repository("movieRepo")
@Transactional
public class MovieDao {

	@Autowired
	private SessionFactory sf;

	public MovieDao() {
		super();
	}
	
	public void insert(Movie m) {
		 sf.getCurrentSession().save(m);
	}
	
	public Movie selectByName(String name) {
		System.out.println(name);
		return sf.getCurrentSession().get(Movie.class, name);
	}
	
	public List<Movie> selectAll() {
		return sf.getCurrentSession().createQuery("FROM Movie", Movie.class).list();
	}
	
}
