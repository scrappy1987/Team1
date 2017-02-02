package com.qa.student.model;

import javax.persistence.*;
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

	@OneToOne
    @MapsId
	Person staffPerson;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="order_id")
	private Order order;
	
	//review
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="id")
	private Review review;
	
	//person
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idPerson", nullable = false)
	@NotNull
	private Person person;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="payment_details_id", nullable=false)
	@NotNull
	private PaymentDetails paymentDetails;
	
	public Person getStaffPerson() {
		return staffPerson;
	}
	
	public void setStaffPerson(Person staffPerson) {
		this.staffPerson = staffPerson;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Review getReview() {
		return review;
	}

	public void setReview(Review review) {
		this.review = review;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public PaymentDetails getPaymentDetails() {
		return paymentDetails;
	}

	public void setPaymentDetails(PaymentDetails paymentDetails) {
		this.paymentDetails = paymentDetails;
	}
	
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