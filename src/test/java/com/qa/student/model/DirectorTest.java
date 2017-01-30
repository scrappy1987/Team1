package com.qa.student.model;

import org.junit.Assert.*;
import org.junit.Test;

public class DirectorTest {	
	
//	@Test
//	public void nameTest() {
//		Director dir = new Director();
//		dir.setDFirst_name(1);
//		assertEquals(dir.getDirector_id, 1);
//		}
	
	@Test
	public void idTest() {
		Director dir = new Director();
		dir.setDirector_id(1);
		assertEquals(dir.getDirector_id, 1);
		}
}