package com.qa.student.rest;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import com.qa.student.model.Order;

import nl.jqno.equalsverifier.EqualsVerifier;

public class OrderTest {
	
	Order order = new Order();
	@Test
	public void testId() {
		order.setId(100l);
		Long l = new Long(100l);
		assertEquals(l,order.getId());
	}
	
	@Test
	public void testTicketId() {
		order.setTicketId(100l);
		Long l = new Long(100l);
		assertEquals(l,order.getTicketId());
	}
	
	@Test
	public void testTotalCost() {
		order.setTotalCost(100d);
		Double d = new Double(100d);
		assertEquals(d,order.getTotalCost());
	}
	
	@Test
	public void testOrderDate() {
		order.setOrderDate(new Date());
		Date date = new Date();
		assertEquals(date,order.getOrderDate());
	}
	
	@Test
	public void testEquals() {
		EqualsVerifier.forClass(Order.class).usingGetClass().verify(); 	
	}
	
	@Test
	public void testToString() {
		Object revString = order.toString();
		assertTrue(revString instanceof String);
	}
}
