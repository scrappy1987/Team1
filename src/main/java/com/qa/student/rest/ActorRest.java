package com.qa.student.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/actor")
public class ActorRest {
	@Inject
	ActorService actorService;
	
	@GET
	@Path("/json")
	@Produces({ "application/json"})
	public String getAllActorID() 
	{
		return actorService.getAllActorID();
	}
	
	@GET
	@Path("/json")
	@Produces({ "application/json"})
	public String getActorID() 
	{
		return actorService.getActorID((long)1);
	}
	
	@GET
	@Path("/json")
	@Produces({ "application/json"})
	public String getActorFirstName() 
	{
		return actorService.getActorFirstName("Testy");
	}
	
	@GET
	@Path("/json")
	@Produces({ "application/json"})
	public String getActorSurname() 
	{
		return actorService.getActorSurname("McTestface");
	}
	
}
