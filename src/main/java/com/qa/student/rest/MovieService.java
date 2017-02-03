package com.qa.student.rest;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.google.gson.Gson;
import com.qa.student.model.Movie;

public class MovieService {
	
	@Inject
	EntityManager em;

	@Inject 
	Gson gson;
	
	public List<Movie> getAllMovies()
	{
		@SuppressWarnings("unchecked")
		List<Movie> movies = em.createQuery("select m from Movie order by m.title").getResultList();
		return movies;
	}
	public Movie getMovieWithID(int movieId)
	{
		Movie movie = em.find(Movie.class, movieId);
		return movie;
		
	}
	public List<Movie> getMovieWithGenre(String genre)
	{
		@SuppressWarnings("unchecked")
		List<Movie> movies = em.createQuery("select m from Movie order by m.title").getResultList();
		return movies;
		
	}
	public void addMovie(String movieString)
	{
		Movie newMovie = gson.fromJson(movieString, Movie.class);
		em.persist(newMovie);
	}
	public void deleteMovie(String movieString)
	{
		Movie aMovie = gson.fromJson(movieString,Movie.class);
		em.remove(aMovie);
	}
	public void deleteMovie(int movie_id)
	{
		@SuppressWarnings("unchecked")
		List<Movie> movies = em.createQuery("select m from Movie order by m.title").getResultList();
		for(Movie movie : movies)
		{
			if(movie.getFilm_id() == movie_id)
			{
				em.remove(movie);
			}
		}
		
	}
	public String convertToJSON(List<Movie> movies)
	{
		return gson.toJson(movies,Movie.class);
	}
	public String convertToJSON(Movie movie)
	{
		return gson.toJson(movie,Movie.class);
	}
}

