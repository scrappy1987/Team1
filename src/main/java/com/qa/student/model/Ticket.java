package com.qa.student.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Ticket {

	@Id
	@GeneratedValue
	@Column(nullable = false)
	private Long id;
	
	//Foreign key - ID of showing
	@Column(nullable = false, name = "showing_id")
	private Long showingID;
	
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

	public Long getShowingID() {
		return showingID;
	}

	public void setShowingID(Long showingID) {
		this.showingID = showingID;
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
		result = prime * result
				+ ((showingID == null) ? 0 : showingID.hashCode());
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
		if (showingID == null) {
			if (other.showingID != null)
				return false;
		} else if (!showingID.equals(other.showingID))
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
		return "Ticket [id=" + id + ", showingID=" + showingID
				+ ", ticketType=" + ticketType + ", seatNumber=" + seatNumber
				+ ", price=" + price + "]";
	}
	
	
	
	
}
