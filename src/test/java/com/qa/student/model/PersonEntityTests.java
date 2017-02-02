
package com.qa.student.model;

import com.qa.student.model.*;

import static org.junit.Assert.*;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

import org.junit.Test;

public class PersonEntityTests {
	@Test
	public void getIdTest(){
		Person person = new Person(0, "firstName", "surname" , "01-01-1970");
		assertEquals(0,person.getIdPerson());
	}
	@Test
	public void getFirstNameTest(){
		Person person = new Person(0, "firstName", "surname" , "01-01-1970");
		assertEquals("firstName",person.getFirstName());	
	}
	@Test
	public void getSurnameTest(){
		Person person = new Person(0, "firstName", "surname" , "01-01-1970");
		assertEquals("surname",person.getSurname());	
	}
	@Test
	public void getDOBTest(){
		Person person = new Person(0, "firstName", "surname" , "01-01-1970");
		assertEquals("01-01-1970",person.getDateOfBirth());	
	}
	@Test
	public void setIdTest(){
		Person person = new Person();
		person.setIdPerson(0);
		assertEquals(0,person.getIdPerson());	
	}
	@Test
	public void setFirstNameTest(){
		Person person = new Person();
		person.setFirstName("firstName");
		assertEquals("firstName",person.getFirstName());	
	}
	@Test
	public void setSurnameTest(){
		Person person = new Person();
		person.setSurname("surname");
		assertEquals("surname",person.getSurname());	
	}
	@Test
	public void setDOBTest(){
		Person person = new Person();
		person.setDateOfBirth("dob");
		assertEquals("dob",person.getDateOfBirth());	
	}
	
	@Test
	public void toStringTest(){
		Person person = new Person(0, "firstName", "surname" , "01-01-1970");
		assertNotNull(person.toString());
	}
	@Test
	public void hashTest(){
		Person person = new Person(0, "firstName", "surname" , "01-01-1970");
		assertNotNull(person.hashCode());
	}
	@Test
	public void equalsTest(){
		EqualsVerifier.forClass(Person.class)
		.usingGetClass()
		.suppress(Warning.STRICT_INHERITANCE)
		.verify();
	}	
}
