package com.qa.student.model;

import java.sql.Time;
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
public class Showing {
	// ======================================
	// = Attributes =
	// ======================================

	@Id
	@GeneratedValue
	private Long id;

	private String showingTime;

	private int showingDuration;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name= "ticketId")
	private Set<Ticket> tickets = new HashSet<Ticket>();

	@ManyToOne
	@JoinColumn(name="screenId",nullable=false)
	@NotNull
	private Screen screen;
	
	@ManyToOne
	@JoinColumn(name="filmId")
	private Movie movie;
	
	// ======================================
	// = Constructors =
	// ======================================
	
	public Showing(){
		
	}
	
	public Showing(String time, int duration){
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

	public String getShowingTime() {
		return showingTime;
	}

	public void setShowingTime(String showingTime) {
		this.showingTime = showingTime;
	}

	public int getShowingDuration() {
		return showingDuration;
	}

	public void setShowingDuration(int showingDuration) {
		this.showingDuration = showingDuration;
	}
	
	public Set<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(Set<Ticket> tickets) {
		this.tickets = tickets;
	}

	public Screen getScreen() {
		return screen;
	}

	public void setScreen(Screen screen) {
		this.screen = screen;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
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
		result = prime * result + ((movie == null) ? 0 : movie.hashCode());
		result = prime * result + ((screen == null) ? 0 : screen.hashCode());
		result = prime * result + showingDuration;
		result = prime * result + ((showingTime == null) ? 0 : showingTime.hashCode());
		result = prime * result + ((tickets == null) ? 0 : tickets.hashCode());
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
		if (movie == null) {
			if (other.movie != null)
				return false;
		} else if (!movie.equals(other.movie))
			return false;
		if (screen == null) {
			if (other.screen != null)
				return false;
		} else if (!screen.equals(other.screen))
			return false;
		if (showingDuration != other.showingDuration)
			return false;
		if (showingTime == null) {
			if (other.showingTime != null)
				return false;
		} else if (!showingTime.equals(other.showingTime))
			return false;
		if (tickets == null) {
			if (other.tickets != null)
				return false;
		} else if (!tickets.equals(other.tickets))
			return false;
		return true;
	}
}
