package com.qa.student.model;

import static org.junit.Assert.*;
import nl.jqno.equalsverifier.EqualsVerifier;

import org.junit.Test;

public class CinemaTest {

	@Test
	public void getCinemaId() {
		Cinema c = new Cinema();
		equals(c.getCinema_Id());
	}

	@Test
	public void setCinemaId() {
		Cinema c = new Cinema();
		c.setCinema_Id(2);
		assertNotEquals(c.getCinema_Id(), null);
	}

	@Test
	public void getName() {
		Cinema c = new Cinema();
		assertEquals(c.getName(), null);
	}

	@Test
	public void setName() {
		Cinema c = new Cinema();
		c.setName("View");
		assertNotEquals(c.getName(), null);
	}

	@Test
	public void getScreens() {
		Cinema c = new Cinema();
		assertEquals(c.getNumOFScreens(), null);
	}

	@Test
	public void setScreens() {
		Cinema c = new Cinema();
		c.setNumOFScreens("");
		assertNotEquals(c.getNumOFScreens(), null);
	}

	@Test
	public void getCapacity() {
		Cinema c = new Cinema();
		equals(c.getCapacity());
	}

	@Test
	public void setCapacity() {
		Cinema c = new Cinema();
		c.setCapacity(0);
		assertNotEquals(c.getCinema_Id(), null);
	}

	@Test
	public void ToString() {
		Cinema c = new Cinema();
		assertNotNull(c.toString());
	}

	@Test
	public void hashcode() {
		Cinema c = new Cinema();
		assertNotNull(c.hashCode());
	}

	@Test
	public void equals() {
		EqualsVerifier.forClass(Cinema.class).usingGetClass().verify();

	}

}
