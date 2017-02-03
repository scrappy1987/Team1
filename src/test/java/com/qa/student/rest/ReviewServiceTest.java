package com.qa.student.rest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.student.model.Review;

@RunWith(MockitoJUnitRunner.class)
public class ReviewServiceTest {

	@Mock
	private EntityManager em;

	@InjectMocks
	private ReviewService reviewService = new ReviewService();

	@Mock
	private Query query;
	
	@Test
	public void testCreateReview() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testRemoveReview() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testGetAllReviews() {
		List<Review> reviewList = new ArrayList<Review>();
		Review aReview = new Review();
		Long id = 10l;
		aReview.setId(id);
		reviewList.add(aReview);
		Mockito.when(em.createQuery(Mockito.anyString())).thenReturn(query);
		Mockito.when(query.getResultList()).thenReturn(reviewList);
		// test the add functionality
		List<Review> assertionList = reviewService.getAllReviews();
		assertEquals(assertionList.get(0).getId(), id);
		// verify the behavior
		Mockito.verify(em).createQuery(Mockito.anyString());
	}

}
