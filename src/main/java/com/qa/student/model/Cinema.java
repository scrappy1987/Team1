package com.qa.student.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
	private int Id;

	@Column(nullable = true, length = 225)
	@Size(max = 225)
	private String screens;

	@Column(nullable = true)
	private int capacity;

	public Cinema() {
	}

	public int getCinemaId() {
		return Id;
	}

	public void setCinemaId(int Id) {
		this.Id = Id;
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

	@Override
	public String toString() {
		return "Cinema [name=" + name + ", Id=" + Id + ", screens=" + screens
				+ ", capacity=" + capacity + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Id;
		result = prime * result + capacity;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((screens == null) ? 0 : screens.hashCode());
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
		if (Id != other.Id)
			return false;
		if (capacity != other.capacity)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (screens == null) {
			if (other.screens != null)
				return false;
		} else if (!screens.equals(other.screens))
			return false;
		return true;
	}

}
