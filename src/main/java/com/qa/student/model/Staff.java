package com.qa.student.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Staff {
	
	@Id
	@GeneratedValue
	private int idPerson;

	@NotNull
	@Column(name = "Job_Role")
	private String jobRole;
	
    @OneToOne 
    @MapsId
	Person staffPerson;
	   
    
    public Staff(){}

    public Staff(String jobRole, Person staffPerson) {
		super();
		this.jobRole = jobRole;
		this.staffPerson = staffPerson;
	}
    
	public Staff(int idPerson, String jobRole, Person staffPerson) {
		super();
		this.idPerson = idPerson;
		this.jobRole = jobRole;
		this.staffPerson = staffPerson;
	}

	public int getIdPerson() {
		return idPerson;
	}

	public void setIdPerson(int idPerson) {
		this.idPerson = idPerson;
	}

	public String getJobRole() {
		return jobRole;
	}

	public void setJobRole(String jobRole) {
		this.jobRole = jobRole;
	}

	public Person getStaffPerson() {
		return staffPerson;
	}

	public void setStaffPerson(Person staffPerson) {
		this.staffPerson = staffPerson;
	}

	@Override
	public String toString() {
		return "Staff [idPerson=" + idPerson + ", jobRole=" + jobRole
				+ ", staffPerson=" + staffPerson + "]";
	}	
	
}
