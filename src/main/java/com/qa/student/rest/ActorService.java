package com.qa.student.rest;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.google.gson.Gson;
import com.qa.student.model.Actor;

import java.util.logging.Logger;

public class ActorService {

	@Inject
	private EntityManager actorEM;
	
	@Inject
	private Gson gson;

	
	public String getAllActorID()
	{
		@SuppressWarnings("unchecked")
		List<Actor> actors = actorEM.createQuery("SELECT a FROM Actor").getResultList();
		//Query actorsID = actorEM.createQuery("SELECT a FROM a");
		String newActor = gson.toJson(actors, Actor.class);
		return  newActor;
	}	
	
	public String getActorID(Long actorID) 
	{
		Actor actor = actorEM.find(Actor.class, actorID);
		String IDResult = gson.toJson(actor, Actor.class);
		return  IDResult;
	}

	public String getActorFirstName(String actorFirstName)
	{
		Actor actor = actorEM.find(Actor.class, actorFirstName);
		String FirstNameResult = gson.toJson(actor, Actor.class);
		return  FirstNameResult;
	}
	
	public String getActorSurname(String actorSurname)
	{
		Actor actor = actorEM.find(Actor.class, actorSurname);
		String SurnameResult = gson.toJson(actor, Actor.class);
		return  SurnameResult;
	}
	
	public void addActor(String jsonString)
	{
		Actor newActor = gson.fromJson(jsonString, Actor.class);
		this.addActor(newActor);
	}
	
	public void addActor(Actor newActor)
	{
		Actor actor = actorEM.find(Actor.class, newActor);
		if(actor != null)
		{
			System.out.println("Actor already exists");
		} else {
			actorEM.persist(newActor);
			System.out.println("Actor added");
		}
	}
	
	public void deleteActor(String jsonString)
	{
		Actor newActor = gson.fromJson(jsonString, Actor.class);
		removeActor(newActor);
	}
	
	public void removeActor(Actor deleteActor)
	{
		Actor actor = actorEM.find(Actor.class, deleteActor);
		if(actor == null)
		{
			System.out.println("Actor doesn't exist");
		} else {
			actorEM.remove(actor);
			System.out.println("Actor deleted");
		}
	}
	
	public void updateActor(String jsonString)
	{
		Actor newActor = gson.fromJson(jsonString, Actor.class);
		updateActor(newActor);
	}
	
	public void updateActor(Actor updateActor)
	{
		Actor actor = actorEM.find(Actor.class, updateActor);
		if(actor == null)
		{
			System.out.println("Actor doesn't exist");
		} else {
			actorEM.merge(actor);
			System.out.println("Actor updated");
		}
	}
}
