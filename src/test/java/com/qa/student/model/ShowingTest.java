package com.qa.student.model;

import static org.junit.Assert.*;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

public class ShowingTest {

	@Test
	public void getIdTest() {
		Showing s = new Showing();
		assertNull(s.getId());
	}

	@Test
	public void setIdTest() {
		Showing s = new Showing();
		s.setId(1L);
		assertNotEquals(s.getId(), null);
	}

	@Test
	public void getShowingTimeTest() {
		Showing s = new Showing("5pm", 180);
		assertEquals("5pm", s.getShowingTime());
	}

	@Test
	public void setShowingTimeTest() {
		Showing s = new Showing("5pm", 180);
		s.setShowingTime("6pm");
		assertEquals("6pm", s.getShowingTime());
	}

	@Test
	public void getShowingDurationTest() {
		Showing s = new Showing("3pm", 240);
		assertEquals(240, s.getShowingDuration());
	}

	@Test
	public void setShowingDurationTest() {
		Showing s = new Showing("3pm", 240);
		s.setShowingDuration(300);
		assertEquals(300, s.getShowingDuration());
	}

	@Test
	public void toStringTest() {
		Showing s = new Showing();
		assertNotNull(s.toString());
	}

	@Test
	public void hashCodeTest() {
		Showing s = new Showing();
		assertNotNull(s.hashCode());
	}

	@Test
	public void equalsContract() {
		EqualsVerifier.forClass(Showing.class)
		.usingGetClass()
		.suppress(Warning.STRICT_INHERITANCE)
		.verify();
	}

}
