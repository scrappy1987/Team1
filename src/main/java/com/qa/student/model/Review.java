package com.qa.student.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;


@Entity
public class Review {
	
	@Id
	@GeneratedValue
	private Long id;

	//Foreign key - id field in reviewer object
	@NotNull
	@Column(nullable = false)
	private Long filmID;
	
	@NotNull
	@Column(nullable = false)
	private int rating;
	
	@Column(length = 300)
	private String reviewText;
	
	public Review () {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getFilmID() {
		return filmID;
	}

	public void setFilmID(Long filmID) {
		this.filmID = filmID;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getReviewText() {
		return reviewText;
	}

	public void setReviewText(String reviewText) {
		this.reviewText = reviewText;
	}
	
}
