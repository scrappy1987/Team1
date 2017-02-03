package com.qa.student.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Customer {
	//primary key
	@Id
	@GeneratedValue
	private int accountNumber;	
  
	//person
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idPerson", nullable = false)
	@NotNull
	private Person person;

	@NotNull
	@Column(name = "Email Address")
	private String email;
	
	@NotNull
	@Column(name = "Phone Number")
	private int phoneNum;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="order_id")
	private List<Order> orders = new ArrayList<Order>();
	
	//review
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="id")
	private List<Review> reviews = new ArrayList<Review>();
	
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="payment_details_id", nullable=false)
	@NotNull
	private List<PaymentDetails> paymentDetails = new ArrayList<PaymentDetails>();

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
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

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public List<PaymentDetails> getPaymentDetails() {
		return paymentDetails;
	}

	public void setPaymentDetails(List<PaymentDetails> paymentDetails) {
		this.paymentDetails = paymentDetails;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountNumber;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((orders == null) ? 0 : orders.hashCode());
		result = prime * result + ((paymentDetails == null) ? 0 : paymentDetails.hashCode());
		result = prime * result + ((person == null) ? 0 : person.hashCode());
		result = prime * result + phoneNum;
		result = prime * result + ((reviews == null) ? 0 : reviews.hashCode());
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
		Customer other = (Customer) obj;
		if (accountNumber != other.accountNumber)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (orders == null) {
			if (other.orders != null)
				return false;
		} else if (!orders.equals(other.orders))
			return false;
		if (paymentDetails == null) {
			if (other.paymentDetails != null)
				return false;
		} else if (!paymentDetails.equals(other.paymentDetails))
			return false;
		if (person == null) {
			if (other.person != null)
				return false;
		} else if (!person.equals(other.person))
			return false;
		if (phoneNum != other.phoneNum)
			return false;
		if (reviews == null) {
			if (other.reviews != null)
				return false;
		} else if (!reviews.equals(other.reviews))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Customer [accountNumber=" + accountNumber + ", email=" + email + ", phoneNum=" + phoneNum + ", orders="
				+ orders + ", reviews=" + reviews + ", person=" + person + ", paymentDetails=" + paymentDetails + "]";
	}
	

}