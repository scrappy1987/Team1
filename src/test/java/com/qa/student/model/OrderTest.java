package com.qa.student.model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import org.junit.Test;

import com.qa.student.model.Order;

import nl.jqno.equalsverifier.EqualsVerifier;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Assert;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;


import com.qa.student.rest.OrderService;
@RunWith(MockitoJUnitRunner.class)
public class OrderTest {
 @InjectMocks
 OrderService orderService = new OrderService();
 @Mock
 EntityManager em;
 @Mock
 Query query;
 @Test
 public void testGetOrder() {
  List<Order> orderList = new ArrayList<Order>();
  Order anOrder = new Order();
  long id = 1l;
  anOrder.setId(id);
  orderList.add(anOrder);
  Mockito.when(em.createQuery(Mockito.anyString())).thenReturn(query);
  Mockito.when(query.getResultList()).thenReturn(orderList);
  // test the add functionality
  List<Order> assertionList = orderService.getAllOrders();
  long idFromReturnedList = assertionList.get(0).getId();
  assertEquals(id,idFromReturnedList);
  // verify the behaviour
  Mockito.verify(em).createQuery(Mockito.anyString());
 }


	
	Order order = new Order();
	@Test
	public void testId() {
		order.setId(100l);
		Long l = new Long(100l);
		assertEquals(l,order.getId());
	}
	
	@Test
	public void testTickets() {
		Ticket tickets = new Ticket();
		order.addTicketToOrder(tickets);
		List<Ticket> T = order.getTickets();
		assertEquals(tickets, T.get(0));
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
