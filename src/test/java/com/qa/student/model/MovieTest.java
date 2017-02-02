package com.qa.student.model;

import static org.junit.Assert.*;

import java.awt.List;
import java.util.ArrayList;
import java.util.Date;

import nl.jqno.equalsverifier.EqualsVerifier;

import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.student.model.Movie;

@RunWith(MockitoJUnitRunner.class)
public class MovieTest {

	@InjectMocks
	Movie movie = new Movie();
	
	@Mock
	EntityManager entityManager;
	
	@Mock
	Query query;
	
	@Test
	public void getFilm_idTest()
	{
		ArrayList<Movie> movieList = new ArrayList<Movie>();
		Movie aMovie = new Movie();
		aMovie.setFilm_id((long) 1);
		movieList.add(aMovie);
	
		assertEquals(1, (long)movieList.get(0).getFilm_id());
	}
	@Test
	public void getTitleTest()
	{
		ArrayList<Movie> movieList = new ArrayList<Movie>();
		Movie aMovie = new Movie();
		aMovie.setTitle("test");
		movieList.add(aMovie);
	
		assertEquals("test", movieList.get(0).getTitle());
	}
	
	@Test
	public void getGenreTest()
	{
		ArrayList<Movie> movieList = new ArrayList<Movie>();
		Movie aMovie = new Movie();
		aMovie.setGenre("test");
		movieList.add(aMovie);
	
		assertEquals("test", movieList.get(0).getGenre());
	}
	
	@Test
	public void getDescriptionTest()
	{
		ArrayList<Movie> movieList = new ArrayList<Movie>();
		Movie aMovie = new Movie();
		aMovie.setDescription("test");
		movieList.add(aMovie);
	
		assertEquals("test", movieList.get(0).getDescription());
	}
	
	@Test
	public void getCertificationTest()
	{
		ArrayList<Movie> movieList = new ArrayList<Movie>();
		Movie aMovie = new Movie();
		aMovie.setCertification("test");
		movieList.add(aMovie);
	
		assertEquals("test", movieList.get(0).getCertification());
	}
	
	@Test
	public void getReleaseDateTest()
	{
		ArrayList<Movie> movieList = new ArrayList<Movie>();
		Movie aMovie = new Movie();
		aMovie.setReleaseDate(new Date());
		movieList.add(aMovie);
	
		assertEquals(new Date(), movieList.get(0).getReleaseDate());
	}
	
	@Test
	public void getDurationTest()
	{
		ArrayList<Movie> movieList = new ArrayList<Movie>();
		Movie aMovie = new Movie();
		aMovie.setDuration(1);
		movieList.add(aMovie);
	
		assertEquals(1, movieList.get(0).getDuration());
	}
	
	@Test
	public void getLanguageTest()
	{
		ArrayList<Movie> movieList = new ArrayList<Movie>();
		Movie aMovie = new Movie();
		aMovie.setLanguage("test");
		movieList.add(aMovie);
	
		assertEquals("test", movieList.get(0).getLanguage());
	}
	
	@Test
	public void equalsTest()
	{
	
		EqualsVerifier.forClass(Movie.class).usingGetClass().verify(); 
	}
	
	@Test
	public void toStringTest()
	{
		Movie aMovie = new Movie();
		assertNotNull(aMovie.toString());
	}
}
