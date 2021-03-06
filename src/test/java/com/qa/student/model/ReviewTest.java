package com.qa.student.model;

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
		Movie movie = new Movie();
		rev.setMovie(movie);
		assertEquals(movie,rev.getMovie());
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
		EqualsVerifier.forClass(Review.class).usingGetClass().verify(); 
		
	}
	
	@Test
	public void testToString() {
		Object revString = rev.toString();
		assertTrue(revString instanceof String);
	}
	
	

}
