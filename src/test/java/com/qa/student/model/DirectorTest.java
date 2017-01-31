package com.qa.student.model;

import static org.junit.Assert.*;

import org.junit.Assert.*;
import org.junit.Test;

public class DirectorTest {	
	
	@Test
	public void firstNameTest() {
		Director dir = new Director();
		dir.setFirst_name("testName");
		assertEquals(dir.getFirst_name(), "testName");
		}
	
	@Test
	public void idTest() {
		Director dir = new Director();
		dir.setDirector_id(1);
		assertEquals(dir.getDirector_id(), 1);
		}
	
	@Test
	public void lastNameTest() {
		Director dir = new Director();
		dir.setSurname("surnameExample");
		assertEquals(dir.getSurname(), "surnameExample");
		}
}