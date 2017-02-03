package com.qa.student.rest;

import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.inject.Inject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.qa.student.model.Director;
import com.qa.student.model.Movie;

public class DirectorService {

	//private static final Logger;

	@Inject
	private Gson Manager;

	@Inject
	private EntityManager em;

	private int id;
	private int keyID;
	private Gson gson;
	private GsonBuilder gsonbuilder;
	//private Map<Integer, Director> DirectorMap;

	public DirectorService(){
		this.id = 1;
		this.keyID = 1;
		this.gson = new Gson();
		this.gsonbuilder = new GsonBuilder();
		//		List mockedList = mock(List.class);
		//		mockedList.add("one");
		//		mockedList.clear();
		//		verify(mockedList).add("one");
		//		verify(mockedList).clear();
	}

	public String addDirectorToDB(Director newDirector){		
		Director tempDir = em.find(Director.class, newDirector);
		if (tempDir != null){
			return "Director not added, already exists.";
		}
		else{
			em.persist(newDirector);
			return "Director successfully added to the database.";
		}
	}

	public Director getDirectorUsingID(int keyToFind){
		Director tempDir = em.find(Director.class, id);
		if(tempDir != null){
			return tempDir;
		}
		else {
			//return "No director found with the given ID.";
			return null;
		}
	}

	public String removeDirectorFromDB(Director directorToRemove){
		Director checker = em.find(Director.class, directorToRemove);
		if(checker == null){
			return "The director doesn't exist.";
		}
		else{
			em.remove(directorToRemove);
			return "You have successfully removed a director";
		}
	}

	//not needed?
	public void addFilmToDirector(int keyToAddTo, Movie newMovie){
		
	}

	public String removeFilmFromDirector(int keyToRemoveFrom, int movieID){
		return null;
		
	}
}