package com.qa.student.model;

import static org.junit.Assert.*;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

public class ScreenTest {
	
	@Test
	public void getIdTest(){
		Screen s = new Screen();
		assertEquals(s.getId(),null);
	}
	
	@Test
	public void setIdTest(){
		Screen s = new Screen();
		s.setId(1L);
		assertNotEquals(s.getId(),null);
	}

	@Test
	public void getNoPremiumSeatsTest() {
		Screen s = new Screen(10,10,5);
		assertEquals(s.getNoPremiumSeats(), 10);
	}
	
	@Test
	public void setNoPremiumSeatsTest() {
		Screen s = new Screen(10,10,5);
		s.setNoPremiumSeats(20);
		assertEquals(s.getNoPremiumSeats(), 20);
	}
	
	@Test
	public void getNoStandardSeatsTest() {
		Screen s = new Screen(10,5,2);
		assertEquals(s.getNoStandardSeats(), 5);
	}
	
	@Test
	public void setNoStandardSeatsTest() {
		Screen s = new Screen(10,5,5);
		s.setNoStandardSeats(15);
		assertEquals(s.getNoStandardSeats(), 15);
	}
	
	@Test
	public void getScreenSizeTest() {
		Screen s = new Screen(10,10,5);
		assertEquals(s.getScreenSize(), 5);
	}
	
	@Test
	public void setScreenSizeTest() {
		Screen s = new Screen(10,10,5);
		s.setScreenSize(8);
		assertEquals(s.getScreenSize(), 8);
	}
	
	@Test
	public void toStringTest(){
		Screen s = new Screen();
		assertNotNull(s.toString());
	}
	
	@Test
	public void hashCodeTest(){
		Screen s = new Screen();
		assertNotNull(s.hashCode());
	}
	
	@Test
	public void equalsContract() {
	    EqualsVerifier.forClass(Screen.class)
	    .suppress(Warning.STRICT_INHERITANCE)
	    .verify();
	}

}
