package com.example.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component("MovieAspect")
public class MovieAspect {
	
	private final static Logger loggy = Logger.getLogger(MovieAspect.class);

	@After("execution(* getAllMovies())")
	public void LogAllMovies(JoinPoint jp) {
		loggy.info("function has been called by using SpringAOP");
	}
	
	@After("execution(* getMovieByName(*))")
	public void LogMovieByName(JoinPoint jp) {
		loggy.info("function by name has been called by using SpringAOP");
	}
}