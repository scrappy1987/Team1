package com.qa.student.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Cinema {

	@NotNull
	private String name;

	@Id
	@GeneratedValue
	private int addressId;

	private String screens;

	private int capacity;

	public Cinema() {

	}

	public int getaddressId() {
		return addressId;
	}

	public void setaddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getScreens() {
		return screens;
	}

	public void setScreens(String screens) {
		this.screens = screens;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
}
