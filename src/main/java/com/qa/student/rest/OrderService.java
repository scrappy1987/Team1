package com.qa.student.rest;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.qa.student.model.Order;

public class OrderService {
	//get all orders
	//get order by id
	//get order by email
	//get order by surname 
	//add order
	//delete order
	
	@Inject
	private EntityManager em;
	
	
	public List<Order> getAllOrders() {
		final List<Order> results = em.createQuery("select all from Order all order by all.name").getResultList();
		return results;
	}
	
	
	
	public List<Order> getOrderById() {
		final List<Order> results = em.createQuery("select id from Order id order by id.name").getResultList();
		return results;
	}
	
	
	
	public List<Order> getOrderByEmail() {
		final List<Order> results = em.createQuery("select email from Order email order by email.name").getResultList();
		return results;
	}
	
	
	
	public List<Order> getOrderBySurname() {
		final List<Order> results = em.createQuery("select surname from Order surname order by surname.name").getResultList();
		return results;
	}
	
	
	
	public void getAddOrder(Order order) {
		em.persist(order);
	}
	
	
	public void getDeleteOrder(Order order) {
		em.remove(order);
	}
	
	public void getUpdateOrder(Order order) {
		em.merge(order);
	}
	
	
	
//	package com.qa.student.rest;
//	import java.util.ArrayList;
//	import java.util.List;
//	import javax.persistence.EntityManager;
//	import javax.persistence.Query;
//	import org.junit.Assert;
//	import org.junit.Test;
//	import org.junit.runner.RunWith;
//	import org.mockito.InjectMocks;
//	import org.mockito.Mock;
//	import org.mockito.Mockito;
//	import org.mockito.runners.MockitoJUnitRunner;
//	import com.qa.student.model.Person;
//	import com.qa.student.rest.PersonService;
//	@RunWith(MockitoJUnitRunner.class)
//	public class PersonServiceTest {
//	 @InjectMocks
//	 PersonService personService = new PersonService();
//	 @Mock
//	 EntityManager em;
//	 @Mock
//	 Query query;
//	 @Test
//	 public void test() {
//	  List<Person> personList = new ArrayList<Person>();
//	  Person aPerson = new Person();
//	  aPerson.setFirstName("test");
//	  personList.add(aPerson);
//	  Mockito.when(em.createQuery(Mockito.anyString())).thenReturn(query);
//	  Mockito.when(query.getResultList()).thenReturn(personList);
//	  // test the add functionality
//	  List<Person> assertionList = personService.getAllPeople();
//	  Assert.assertEquals(assertionList.get(0).getFirstName(), "test");
//	  // verify the behavior
//	  Mockito.verify(em).createQuery(Mockito.anyString());
//	 }
//	}

}
