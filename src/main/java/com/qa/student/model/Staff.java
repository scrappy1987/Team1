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

	/* @OneToOne 
    @MapsId
	Person staffPerson;*/

	public Staff(){}

	public Staff(int idPerson, String jobRole) {
		super();
		this.idPerson = idPerson;
		this.jobRole = jobRole;
	}
	public Staff( String jobRole) {
		super();
		this.jobRole = jobRole;
	}

	/*  public Staff(String jobRole, Person staffPerson) {
		super();
		this.jobRole = jobRole;
		this.staffPerson = staffPerson;
	}

	public Staff(int idPerson, String jobRole, Person staffPerson) {
		super();
		this.idPerson = idPerson;
		this.jobRole = jobRole;
		this.staffPerson = staffPerson;
	}*/

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
	

	@Override
	public String toString() {
		return "Staff [idPerson=" + idPerson + ", jobRole=" + jobRole + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idPerson;
		result = prime * result + ((jobRole == null) ? 0 : jobRole.hashCode());
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
		Staff other = (Staff) obj;
		if (idPerson != other.idPerson)
			return false;
		if (jobRole == null) {
			if (other.jobRole != null)
				return false;
		} else if (!jobRole.equals(other.jobRole))
			return false;
		return true;
	}
	/*	public Person getStaffPerson() {
		return staffPerson;
	}

	public void setStaffPerson(Person staffPerson) {
		this.staffPerson = staffPerson;
	}*/

	/*@Override
	public String toString() {
		return "Staff [idPerson=" + idPerson + ", jobRole=" + jobRole
				+ ", staffPerson=" + staffPerson + "]";
	}	*/
}
