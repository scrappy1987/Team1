package com.qa.student.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
public class PaymentDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long payment_details_id;
  
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="customer_id", nullable=false)
	@NotNull
	private Customer customer;
  
	@Column(nullable=false)
	@NotNull
	private Integer cardNumber;
	
	@Column(nullable=false)
	@NotNull
	private String CardName;
	
	@Column(nullable=false)
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date expiryDate;
	
	public PaymentDetails() {
		super();
	}

	public Long getPayment_details_id() {
		return payment_details_id;
	}


	public void setPayment_details_id(Long payment_details_id) {
		this.payment_details_id = payment_details_id;
	}

	public Integer getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(Integer cardNumber) {
		this.cardNumber = cardNumber; 
	}

	public String getCardName() {
		return CardName;
	}

	public void setCardName(String cardName) {
		CardName = cardName;
	}
	
	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}	

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "PaymentDetails [payment_details_id=" + payment_details_id
				+ ", cardNumber=" + cardNumber + ", expiryDate=" + expiryDate
				+ "]";
	}

//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result
//				+ ((cardNumber == null) ? 0 : cardNumber.hashCode());
//		result = prime * result + expiryDate;
//		result = prime
//				* result
//				+ ((payment_details_id == null) ? 0 : payment_details_id
//						.hashCode());
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		PaymentDetails other = (PaymentDetails) obj;
//		if (cardNumber == null) {
//			if (other.cardNumber != null)
//				return false;
//		} else if (!cardNumber.equals(other.cardNumber))
//			return false;
//		if (expiryDate != other.expiryDate)
//			return false;
//		if (payment_details_id == null) {
//			if (other.payment_details_id != null)
//				return false;
//		} else if (!payment_details_id.equals(other.payment_details_id))
//			return false;
//		return true;
//	}
	
	
}
