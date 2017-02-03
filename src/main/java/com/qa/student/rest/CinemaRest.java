package com.qa.student.rest;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.qa.student.model.Cinema;

@Path("/json")
public class CinemaRest {
	
	@Inject
	CinemaService cinemaService;
	
	@Inject
	ScreenService screenService;
	
	@Inject
	ShowingService showingService;
	
	@Inject
	StaffService staffService;
	
	@Inject
	AddressService addressService;
	
	@Inject 
	EntityManager em;
	
	@Inject
	Gson gson;
	
	@GET
	@Path("/getAllCinemas")
	@Produces({"application/json"})
	public String getAllCinemasJSON(){
		String output = gson.toJson(cinemaService.getAllCinemaList());
		return output;
	}
	
	@POST
	@Path("/post")
	@Consumes({"application/json"})
	@Produces({MediaType.TEXT_PLAIN})
	public String addCinemaJSON(String jsonString){
		Cinema cinema = gson.fromJson(jsonString, Cinema.class);
		cinemaService.createCinema(cinema);
		return "Cinema created successfully";
	}
}
