package com.qa.student.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Staff")
public class Staff {

	@Id
	@GeneratedValue
	private int idStaff;

	@NotNull
	@Column(name = "Job_Role")
	private String jobRole;

	@OneToOne 
    @MapsId
	Person staffPerson;

	public Staff(){}

	public Staff(int idPerson, String jobRole) {
		super();
		this.idStaff = idPerson;
		this.jobRole = jobRole;
	}
	public Staff( String jobRole) {
		super();
		this.jobRole = jobRole;
	}

	public Staff(String jobRole, Person staffPerson) {
		super();
		this.jobRole = jobRole;
		this.staffPerson = staffPerson;
	}

	public Staff(int idStaff, String jobRole, Person staffPerson) {
		super();
		this.idStaff = idStaff;
		this.jobRole = jobRole;
		this.staffPerson = staffPerson;
	}

	public int getIdPerson() {
		return idStaff;
	}

	public void setIdPerson(int idStaff) { 
		this.idStaff = idStaff;
	}

	public String getJobRole() {
		return jobRole;
	}

	public void setJobRole(String jobRole) {
		this.jobRole = jobRole;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idStaff;
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
		if (idStaff != other.idStaff)
			return false;
		if (jobRole == null) {
			if (other.jobRole != null)
				return false;
		} else if (!jobRole.equals(other.jobRole))
			return false;
		return true;
	}
	public Person getStaffPerson() {
		return staffPerson;
	}

	public void setStaffPerson(Person staffPerson) {
		this.staffPerson = staffPerson;
	}

	@Override
	public String toString() {
		return "Staff [idPerson=" + idStaff + ", jobRole=" + jobRole
				+ ", staffPerson=" + staffPerson + "]";
	}

	public int getIdStaff() {
		return idStaff;
	}

	public void setIdStaff(int idStaff) {
		this.idStaff = idStaff;
	}	
}
