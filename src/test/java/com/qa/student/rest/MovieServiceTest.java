package com.qa.student.rest;


import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.google.gson.Gson;
import com.qa.student.model.Movie;


@RunWith(MockitoJUnitRunner.class)
public class MovieServiceTest {
	
	@InjectMocks
	MovieService movieService = new MovieService();
	
	@Mock 
	EntityManager em;
	
	@Mock
	Query query;
	
	@Test
	public void test()
	{
		 List<Movie> personList = new ArrayList<Movie>();
		  Movie aPerson = new Movie();
		  aPerson.setFilm_id(1l);
		  personList.add(aPerson);
		  Mockito.when(em.createQuery(Mockito.anyString())).thenReturn(query);
		  Mockito.when(query.getResultList()).thenReturn(personList);
		  // test the add functionality
		  List<Movie> assertionList = movieService.getAllMovies();

		  assertEquals(assertionList.get(0).getFilm_id(), 1l);

		  // verify the behavior
		  Mockito.verify(em).createQuery(Mockito.anyString());;
		
	}

}
