package com.qa.student.rest;

import static org.junit.Assert.*;

import nl.jqno.equalsverifier.EqualsVerifier;

import org.junit.Test;

import com.qa.student.model.Review;

public class ReviewTest {

	Review rev = new Review();
	@Test
	public void testID() {
		rev.setId(100l);
		Long l = new Long(100l);
		assertEquals(l,rev.getId());
	}
	
	@Test
	public void testFilmID() {
		rev.setFilmID(101l);
		Long l = new Long(101l);
		assertEquals(l,rev.getFilmID());
	}
	
	@Test
	public void rating() {
		rev.setRating(5);
		assertEquals(5,rev.getRating());
	}
	
	@Test
	public void testReviewText() {
		rev.setReviewText("A review");
		assertEquals("A review",rev.getReviewText());
	}
	
	@Test
	public void testEquals() {
//		rev.setId(100l);
//		rev.setFilmID(101l);
//		rev.setRating(5);
//		rev.setReviewText("A review");
//		Review revTwo = new Review(); 
//		revTwo.setId(100l);
//		revTwo.setFilmID(101l);
//		revTwo.setRating(5);
//		revTwo.setReviewText("A review");
		EqualsVerifier.forClass(Review.class).usingGetClass().verify();
		
	}
	
	@Test
	public void testToString() {
		Object revString = rev.toString();
		assertTrue(revString instanceof String);
	}
	
	

}
