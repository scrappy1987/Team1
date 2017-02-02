package com.qa.student.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Screen {
	
	// ======================================
	// = Attributes =
	// ======================================
	
	@Id
	@GeneratedValue
	private Long id;
	
	private int noPremiumSeats;

	private int noStandardSeats;

	private int screenSize;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name= "showingId")
	private Set<Showing> showings = new HashSet<Showing>();
	
	@ManyToOne
	@JoinColumn(name="cinemaId",nullable=false)
	@NotNull
	private Cinema cinema;
	
	// ======================================
	// = Constructors =
	// ======================================
	
	public Screen() {
		
	}
	
	public Screen(int premium, int standard, int screenSize) {
		this.noPremiumSeats = premium;
		this.noStandardSeats = standard;
		this.screenSize = screenSize;
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

	public int getNoPremiumSeats() {
		return noPremiumSeats;
	}

	public void setNoPremiumSeats(int noPremiumSeats) {
		this.noPremiumSeats = noPremiumSeats;
	}

	public int getNoStandardSeats() {
		return noStandardSeats;
	}

	public void setNoStandardSeats(int noStandardSeats) {
		this.noStandardSeats = noStandardSeats;
	}

	public int getScreenSize() {
		return screenSize;
	}

	public void setScreenSize(int screenSize) {
		this.screenSize = screenSize;
	}
	
	public Set<Showing> getShowings() {
		return showings;
	}

	public void setShowings(Set<Showing> showings) {
		this.showings = showings;
	}

	public Cinema getCinema() {
		return cinema;
	}

	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}
	
	// ======================================
	// = hashcode, equals & toString =
	// ======================================

	@Override
	public String toString() {
		return "Screen [id=" + id + ", noPremiumSeats=" + noPremiumSeats + ", noStandardSeats=" + noStandardSeats
				+ ", screenSize=" + screenSize + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + noPremiumSeats;
		result = prime * result + noStandardSeats;
		result = prime * result + screenSize;
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
		Screen other = (Screen) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (noPremiumSeats != other.noPremiumSeats)
			return false;
		if (noStandardSeats != other.noStandardSeats)
			return false;
		if (screenSize != other.screenSize)
			return false;
		return true;
	}
}