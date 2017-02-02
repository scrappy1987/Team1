package com.qa.student.model;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Customer {
	//primary key
	@Id
	@GeneratedValue
	private int accountNumber;
	
	//foreign key
	@Id
	private int personID;
	
	@NotNull
	@Column(name = "Email Address")
	private String email;
	
	@NotNull
	@Column(name = "Phone Number")
	private int phoneNum;

	/* @OneToOne
    @MapsId
	Person staffPerson;*/
	
	
	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getPersonID() {
		return personID;
	}

	public void setPersonID(int personID) {
		this.personID = personID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(int phoneNum) {
		this.phoneNum = phoneNum;
	}
}