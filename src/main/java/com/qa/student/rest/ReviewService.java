package com.qa.student.rest;

import java.util.List;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.google.gson.Gson;
import com.qa.student.model.Review;

public class ReviewService {

	private static final Logger LOGGER = Logger.getLogger(ReviewService.class
			.getName());
	private Gson gson;

	@Inject
	private EntityManager em;

	public ReviewService() {
		gson = new Gson();
	}
	
	public void createReview(Review review) {
		if (findReview(review.getId()) == null) em.persist(review);
	}
	
	public void createReview(String review) {
		createReview(gson.fromJson(review, Review.class));
	}

	public Review findReview(Long id) {
		return em.find(Review.class, id);
	}
	
	public void updateReview(Review review) {
		em.merge(review);
	}
	
	public void removeReview(Long id) {
		Review review = findReview(id);
		if (review == null) LOGGER.info("Review ID:"+id+" does not exist");
		else em.remove(review);
	}
	
	public void removeReview(String review) {
		removeReview(gson.fromJson(review, Review.class).getId());
	}
	
	public void removeTicket(Review review) {
		removeReview(review.getId());
	}
	
	public List<Review> getAllReviews() {
		final List<Review> results = em.createQuery("select r from Review r order by r.name").getResultList();
		return results;
	}

}
