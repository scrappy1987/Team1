package com.qa.student.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

//import java.util.HashSet;
//import java.util.Set;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import static javax.persistence.GenerationType.IDENTITY;
//import javax.persistence.CascadeType;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
//import javax.persistence.ManyToMany;
//import javax.persistence.Table;
//import javax.persistence.UniqueConstraint;


public class Actor {
	@Id
	@GeneratedValue
	private Long actor_id;
	
	@NotNull
	private String first_name;
	@NotNull
	private String surname;

	@Column(name = "actor_id", unique = true, nullable = false)
	public Long getActorId() {
		return actor_id;
	}
	public void setActorId(Long actor_id) {
		this.actor_id = actor_id;
	}
	
	@Column(name = "First_name", nullable = false, length = 20)
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	
	@Column(name = "Surname", nullable = false, length = 20)
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((actor_id == null) ? 0 : actor_id.hashCode());
		result = prime * result
				+ ((first_name == null) ? 0 : first_name.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
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
		Actor other = (Actor) obj;
		if (actor_id == null) {
			if (other.actor_id != null)
				return false;
		} else if (!actor_id.equals(other.actor_id))
			return false;
		if (first_name == null) {
			if (other.first_name != null)
				return false;
		} else if (!first_name.equals(other.first_name))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;  
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Actor [actor_id=" + actor_id + ", first_name=" + first_name
				+ ", surname=" + surname + "]";
	}

	
	
	
	
//	@ManyToMany(cascade = CascadeType.ALL)
//	@JoinTable(name = "Film_Actor_Join", joinColumns = 
//			{
//			@JoinColumn(name = "actor_id", nullable = false) 
//			},
//			inverseJoinColumns = { 
//			@JoinColumn(name = "film_id", nullable = false)
//			})

}
