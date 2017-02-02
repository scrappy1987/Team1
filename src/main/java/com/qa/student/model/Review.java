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

	@Override
	public String toString() {
		return "Review [id=" + id + ", filmID=" + filmID + ", rating=" + rating
				+ ", reviewText=" + reviewText + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((filmID == null) ? 0 : filmID.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + rating;
		result = prime * result
				+ ((reviewText == null) ? 0 : reviewText.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Review other = (Review) obj;
		if (filmID == null) {
			if (other.filmID != null)
				return false;
		} else if (!filmID.equals(other.filmID))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id)) 
			return false;
		if (rating != other.rating)
			return false;
		if (reviewText == null) {
			if (other.reviewText != null)
				return false;
		} else if (!reviewText.equals(other.reviewText))
			return false;
		return true;
	}
	
	
	
}
