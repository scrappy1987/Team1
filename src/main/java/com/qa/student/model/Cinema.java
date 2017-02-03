package com.qa.student.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Cinema")
public class Cinema {

	@Column(nullable = false, length = 225)
	@Size(max = 225)
	@NotNull
	private String name;

	@Id
	@Column(nullable = false, unique = true)
	@GeneratedValue
	private int cinema_Id;

	@Column(nullable = true, length = 225)
	@Size(max = 225)
	private String numOFScreens;

	@Column(nullable = true)
	private int capacity;

	@OneToOne
	@JoinColumn(name = "address_id", nullable = false)
	@NotNull
	private Address address;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "Screen_id", nullable = false)
	@NotNull
	private Set<Screen> screens = new HashSet<Screen>();

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "Staff_id", nullable = false)
	@NotNull
	private Set<Staff> staff = new HashSet<Staff>();

	public Cinema() {
	}
	
	public String getName() {
		return name;
	}
	

	public void setName(String name) {
		this.name = name;
	}


	public int getCinema_Id() {
		return cinema_Id;
	}


	public void setCinema_Id(int cinema_Id) {
		this.cinema_Id = cinema_Id;
	}


	public String getNumOFScreens() {
		return numOFScreens;
	}


	public void setNumOFScreens(String numOFScreens) {
		this.numOFScreens = numOFScreens;
	}


	public int getCapacity() {
		return capacity;
	}


	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	public Set<Screen> getScreens() {
		return screens;
	}


	public void setScreens(Set<Screen> screens) {
		this.screens = screens;
	}


	public Set<Staff> getStaff() {
		return staff;
	}


	public void setStaff(Set<Staff> staff) {
		this.staff = staff;
	}


	@Override
	public String toString() {
		return "Cinema [name=" + name + ", Id=" + cinema_Id + ", screens="
				+ numOFScreens + ", capacity=" + capacity + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cinema_Id;
		result = prime * result + capacity;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((numOFScreens == null) ? 0 : numOFScreens.hashCode());
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
		Cinema other = (Cinema) obj;
		if (cinema_Id != other.cinema_Id)
			return false;
		if (capacity != other.capacity)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (numOFScreens == null) {
			if (other.numOFScreens != null)
				return false;
		} else if (!numOFScreens.equals(other.numOFScreens))
			return false;
		return true;
	}

}
