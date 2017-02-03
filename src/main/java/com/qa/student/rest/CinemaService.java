package com.qa.student.rest;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.jboss.logging.Logger;

import com.google.gson.Gson;
import com.qa.student.model.Cinema;

public class CinemaService {

	private static final Logger cinemaLogger = Logger.getLogger(Cinema.class);

	private static final String jsonString = null;

	@Inject
	private EntityManager em;

	@Inject
	private Gson gsonObject;

	public void cresteCinema(String json) {
		Cinema cinema = gsonObject.fromJson(json, Cinema.class);
		createCinema(cinema);
	}

	public void createCinema(Cinema cinema) {
		Cinema checker = em.find(Cinema.class, cinema);

		if (checker == null) {
			cinemaLogger.info("Cinema not added, already exists");
		} else {
			em.persist(cinema);
			cinemaLogger.info("Cinema added successfully");
		}
	}

	public String getCinema(int cinema_id) {
		Cinema cinema = em.find(Cinema.class, cinema_id);

		if (cinema == null) {
			cinemaLogger.info("Cinema_id does not exist");
			return "Cinema_id does not exist";
		} else {
			String jsonStringCinema = gsonObject.toJson(cinema);
			return jsonStringCinema;
		}

	}

	public void updateCinema(String json) {
		Cinema cinema = gsonObject.fromJson(jsonString, Cinema.class);
		updateCinema(cinema);
	}

	public void updateCinema(Cinema cinema) {
		Cinema checker = em.find(Cinema.class, cinema);
		if (checker == null) {
			cinemaLogger.info("Cinema does not exist");
		} else {
			em.merge(cinema);
			cinemaLogger.info("Cinema updated successfully");
		}

	}

	public void removeCinema(String json) {
		Cinema cinema = gsonObject.fromJson(jsonString, Cinema.class);
		removeCinema(cinema);
	}

	public void removeCinema(Cinema cinema) {
		Cinema checker = em.find(Cinema.class, cinema);
		if (checker == null) {
			cinemaLogger.info("Cinema does not exist");
		} else {
			em.remove(cinema);
			cinemaLogger.info("Cinema removed successfully");
		}

	}
}
