package com.qa.student.rest;

import static org.junit.Assert.*;
import nl.jqno.equalsverifier.EqualsVerifier;

import org.junit.Test;

import com.qa.student.model.Ticket;

public class TicketTest {
	
	Ticket ticket = new Ticket();

	@Test
	public void testID() {
		ticket.setId(305l);
		Long l = new Long(305l);
		assertEquals(l,ticket.getId());
	}
	
	@Test
	public void testShowingID() {
		ticket.setShowingID(670l);
		Long l = new Long(670l);
		assertEquals(l,ticket.getShowingID());
	}

	@Test
	public void testTicketType() {
		ticket.setTicketType("Adult");
		assertEquals("Adult",ticket.getTicketType());
	}
	
	@Test
	public void testSeatNumber() {
		ticket.setSeatNumber(54);
		assertEquals(54,ticket.getSeatNumber());
	}
	
	@Test
	public void testPrice() {
		ticket.setPrice(7.99);
		assertEquals(7.99,ticket.getPrice(),0.00);
	}
	
	@Test
	public void testToString() {
		Object obj = ticket.toString();
		assertTrue(obj instanceof String);
	}
	
	@Test
	public void testEquals() {
		EqualsVerifier.forClass(Ticket.class).usingGetClass().verify();
	}
}
