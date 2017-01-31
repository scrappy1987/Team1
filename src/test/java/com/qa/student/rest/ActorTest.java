package com.qa.student.rest;

import org.junit.Test;
import nl.jqno.equalsverifier.EqualsVerifier;
import static org.junit.Assert.*;
import com.qa.student.model.Actor;


public class ActorTest {
	
	@Test
	public void testGetActorId() {
		Actor act = new Actor();
		act.setActorId((long)1);
		long result = act.getActorId();
		assertEquals(1, result);
	}

	@Test
	public void testGetFirst_name() {
		Actor act = new Actor();
		act.setFirst_name("Testy");
		String result = act.getFirst_name();
		assertEquals("Testy", result);
	}

	@Test
	public void testGetSurname() {
		Actor act = new Actor();
		act.setSurname("McTestFace");
		String result = act.getSurname();
		assertEquals("McTestFace", result);
	}

	@Test
	public void testEquals() {
		EqualsVerifier.forClass(Actor.class).usingGetClass().verify();
	} 

	@Test
	public void testToString() {
		Actor act = new Actor();
		assertNotNull(act.toString());
	}
}
