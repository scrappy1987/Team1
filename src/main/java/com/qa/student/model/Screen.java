package com.qa.student.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Screen {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private int noPremiumSeats;

	private int noStandardSeats;

	private int screenSize;
	
	public Screen() {

	}

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
	
	
}