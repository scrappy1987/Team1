package com.qa.student.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Ticket {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "showing_id", nullable = false)
	@Column(nullable = false, name = "showing")
	private Showing showing;
	
	@Column(nullable = false, name = "ticket_type")
	private String ticketType;
	
	@Column(nullable = false, name = "seat_number")
	private int seatNumber;
	
	@Column(nullable = false)
	private double price;

	public Ticket() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Showing getShowing() {
		return showing;
	}

	public void setShowing(Showing showing) {
		this.showing = showing;
	}

	public String getTicketType() {
		return ticketType;
	}

	public void setTicketType(String ticketType) {
		this.ticketType = ticketType;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + seatNumber;
		result = prime * result + ((showing == null) ? 0 : showing.hashCode());
		result = prime * result
				+ ((ticketType == null) ? 0 : ticketType.hashCode());
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
		Ticket other = (Ticket) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (Double.doubleToLongBits(price) != Double
				.doubleToLongBits(other.price))
			return false;
		if (seatNumber != other.seatNumber)
			return false;
		if (showing == null) {
			if (other.showing != null)
				return false;
		} else if (!showing.equals(other.showing))
			return false;
		if (ticketType == null) {
			if (other.ticketType != null)
				return false;
		} else if (!ticketType.equals(other.ticketType))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", showing=" + showing + ", ticketType="
				+ ticketType + ", seatNumber=" + seatNumber + ", price="
				+ price + "]";
	}
	
	
	
}
