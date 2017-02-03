package com.qa.student.rest;

import java.util.List;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.google.gson.Gson;
import com.qa.student.model.Ticket;

public class TicketService {
	
	private static final Logger LOGGER = Logger.getLogger(TicketService.class.getName());
	private Gson gson;
	
	@Inject
	private EntityManager em;
	
	public TicketService() {
		gson = new Gson();
	}

	public void createTicket(Ticket ticket) {
		if (findTicket(ticket.getId()) == null) {em.persist(ticket);System.out.println("done");}
		else LOGGER.info("Ticket ID:"+ticket.getId()+" already exists");
	}
	
	public void createTicket(String ticket) {
		createTicket(gson.fromJson(ticket, Ticket.class));
	}
	
	public Ticket findTicket(Long id) {
		System.out.println("received id:"+id);
		Ticket out = em.find(Ticket.class, id);
		System.out.println("found ticket"+out);
		return out;
	}

	public void removeTicket(Long id) {
		Ticket ticket = findTicket(id);
		if (ticket == null) LOGGER.info("Ticket ID:"+id+" does not exist");
		else em.remove(ticket);
	}
	
	public void removeTicket(String ticket) {
		removeTicket(gson.fromJson(ticket, Ticket.class).getId());
	}
	
	public void removeTicket(Ticket ticket) {
		removeTicket(ticket.getId());
	}

	public List<Ticket> getAllTickets() {
		final List<Ticket> results = em.createQuery("select t from Ticket t order by t.name").getResultList();
		return results;
	}
}
