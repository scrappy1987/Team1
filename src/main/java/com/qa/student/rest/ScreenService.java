package com.qa.student.rest;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.jboss.logging.Logger;

import com.google.gson.Gson;
import com.qa.student.model.Screen;

public class ScreenService {
	
	private static final Logger SCREENLOGGER = Logger.getLogger(Screen.class);
	
	@Inject
	private EntityManager em;
	
	@Inject
	private Gson gsonParser;
	
	public void createScreen(String jsonString){
		Screen screen = gsonParser.fromJson(jsonString, Screen.class);
		this.createScreen(screen);
	}
	
	public void createScreen(Screen screen){
		Screen checker = em.find(Screen.class, screen);
		if(checker != null){
			SCREENLOGGER.info("Screen not added, already exists");
		} else {
			em.persist(screen);
			SCREENLOGGER.info("Screen added successfully");
		}
	}
	
	public Screen getScreen(long id){
		Screen screen = em.find(Screen.class,id);
		if(screen == null){
			SCREENLOGGER.info("Screen of given id doesn't exists");
			return null;
		}
		else {
			return screen;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Screen> getScreenAll(){
		Query query = em.createQuery("SELECT s FROM Screen s");
		if(query == null){
			SCREENLOGGER.info("No Screens exist");
			return null;
		} else {
			List<Screen> resultList = query.getResultList();
			return resultList;
		}
	}
	
	public void removeScreen(String jsonString){
		Screen screen = gsonParser.fromJson(jsonString, Screen.class);
		removeScreen(screen);
	}
	
	public void removeScreen(Screen screen){
		Screen checker = em.find(Screen.class, screen);
		if(checker == null){
			SCREENLOGGER.info("Screen doesn't exist");
		} else {
			em.remove(screen);
			SCREENLOGGER.info("Screen removed successfully");
		}
	}
	
	public void updateScreen(String jsonString){
		Screen screen = gsonParser.fromJson(jsonString, Screen.class);
		updateScreen(screen);
	}
	
	public void updateScreen(Screen screen){
		Screen checker = em.find(Screen.class, screen);
		if(checker == null){
			SCREENLOGGER.info("Screen doesn't exist");
		} else {
			em.merge(screen);
			SCREENLOGGER.info("Screen updated successfully");
		}
	}
}
