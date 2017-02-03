package com.qa.student.rest;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.jboss.logging.Logger;

import com.google.gson.Gson;
import com.qa.student.model.Showing;

public class ShowingService {
	private static final Logger SCREENLOGGER = Logger.getLogger(Showing.class);
	
	@Inject
	private EntityManager em;
	
	@Inject
	private Gson gsonParser;
	
	public void createShowing(String jsonString){
		Showing showing = gsonParser.fromJson(jsonString, Showing.class);
		this.createShowing(showing);
	}
	
	public void createShowing(Showing showing){
		Showing checker = em.find(Showing.class, showing);
		if(checker != null){
			SCREENLOGGER.info("Showing not added, already exists");
		} else {
			em.persist(showing);
			SCREENLOGGER.info("Showing added successfully");
		}
	}
	
	public Showing getShowing(long id){
		Showing showing = em.find(Showing.class, id);
		if(showing == null){
			SCREENLOGGER.info("Showing of given id doesn't exist");
			return null;
		} else {
			return showing;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Showing> getShowingAll(){
		Query query = em.createQuery("SELECT s FROM Showing s");
		if(query == null){
			SCREENLOGGER.info("No Showing exist");
			return null;
		} else {
			List<Showing> resultList = query.getResultList();
			return resultList;
		}
	}
	
	public void removeShowing(String jsonString){
		Showing showing = gsonParser.fromJson(jsonString, Showing.class);
		removeShowing(showing);
	}
	
	public void removeShowing(Showing screen){
		Showing checker = em.find(Showing.class, screen);
		if(checker == null){
			SCREENLOGGER.info("Screen doesn't exist");
		} else {
			em.remove(screen);
			SCREENLOGGER.info("Screen removed successfully");
		}
	}
	
	public void updateShowing(String jsonString){
		Showing showing = gsonParser.fromJson(jsonString, Showing.class);
		updateShowing(showing);
	}
	
	public void updateShowing(Showing showing){
		Showing checker = em.find(Showing.class, showing);
		if(checker == null){
			SCREENLOGGER.info("Screen doesn't exist");
		} else {
			em.merge(showing);
			SCREENLOGGER.info("Screen updated successfully");
		}
	}
}
