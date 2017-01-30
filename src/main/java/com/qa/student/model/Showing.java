package com.qa.student.model;

import java.sql.Time;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Showing {
	// ======================================
	// = Attributes =
	// ======================================

	@Id
	@GeneratedValue
	private Long id;

	private Time showingTime;

	private Time showingDuration;

	// ======================================
	// = Constructors =
	// ======================================
	
	public Showing(){
		
	}
	
	public Showing(Time time, Time duration){
		this.showingTime = time;
		this.showingDuration = duration;
	}
	
	// ======================================
	// = Getters & Setters =
	// ======================================
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Time getShowingTime() {
		return showingTime;
	}

	public void setShowingTime(Time showingTime) {
		this.showingTime = showingTime;
	}

	public Time getShowingDuration() {
		return showingDuration;
	}

	public void setShowingDuration(Time showingDuration) {
		this.showingDuration = showingDuration;
	}
	
	// ======================================
	// = hashcode, equals & toString =
	// ======================================
	
	@Override
	public String toString() {
		return "Showing [id=" + id + ", showingTime=" + showingTime + ", showingDuration=" + showingDuration + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((showingDuration == null) ? 0 : showingDuration.hashCode());
		result = prime * result + ((showingTime == null) ? 0 : showingTime.hashCode());
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
		Showing other = (Showing) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (showingDuration == null) {
			if (other.showingDuration != null)
				return false;
		} else if (!showingDuration.equals(other.showingDuration))
			return false;
		if (showingTime == null) {
			if (other.showingTime != null)
				return false;
		} else if (!showingTime.equals(other.showingTime))
			return false;
		return true;
	}
}
