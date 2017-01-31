package com.qa.student.rest;

import static org.junit.Assert.*;

import org.junit.Test;

import com.qa.student.model.Staff;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;


public class StaffTest {

	@Test
	public void getIdTest(){
		Staff staff = new Staff(0, "role");
		assertEquals(0, staff.getIdPerson());
	}
	@Test
	public void getJobRole(){
		Staff staff = new Staff(0, "role");
		assertEquals("role", staff.getJobRole());
	}
	
	@Test
	public void setIdTest(){
		Staff staff = new Staff(0, "role");
		staff.setIdPerson(1);
		assertEquals(1, staff.getIdPerson());
	}
	@Test
	public void setJobRole(){
		Staff staff = new Staff(0, "role");
		staff.setJobRole("newRole");
		assertEquals("newRole", staff.getJobRole());
	}
	
	
	@Test
	public void toStringTest(){
		Staff staff = new Staff();
		staff.setIdPerson(0);
		staff.setJobRole("role");
		assertNotNull(staff.toString());
		
	}
	@Test
	public void equalsTest(){
		EqualsVerifier.forClass(Staff.class)
		.usingGetClass()
		.suppress(Warning.STRICT_INHERITANCE)
		.verify();
	}
	@Test
	public void hashTest(){
		Staff staff = new Staff("role");
		staff.setIdPerson(0);
		assertNotNull(staff.hashCode());
	}
}
