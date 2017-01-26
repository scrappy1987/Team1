package com.qa.student.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Reviewer {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	private String firstName;
	
	@NotNull
	private String surname;
	
	private boolean professional;
	
	private String company;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public boolean isProfessional() {
		return professional;
	}

	public void setProfessional(boolean professional) {
		this.professional = professional;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
}
