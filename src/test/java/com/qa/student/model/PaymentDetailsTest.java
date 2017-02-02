package com.qa.student.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

//import nl.jqno.equalsverifier.EqualsVerifier;

import org.junit.Test;

import com.qa.student.model.PaymentDetails;

public class PaymentDetailsTest {
	@Test
	public void testGetPayment_details_id() {
		PaymentDetails paymentDetail = new PaymentDetails();
		paymentDetail.setPayment_details_id((long)1);
		long result = paymentDetail.getPayment_details_id();
		assertEquals(1, result);
	} 

	@Test
	public void testGetCardNumber() {
		PaymentDetails paymentDetail = new PaymentDetails();
		paymentDetail.setCardNumber(12345234);
		int result = paymentDetail.getCardNumber();
		assertEquals(12345234, result);
	}
	
	@Test
	public void testGetCardName() {
		PaymentDetails paymentDetail = new PaymentDetails();
		paymentDetail.setCardName("Joe A Bloggs");
		String result = paymentDetail.getCardName();
		assertEquals("Joe A Bloggs", result);
	}

	@Test
	public void testGetExpiryDate() {
		PaymentDetails paymentDetail = new PaymentDetails();
		paymentDetail.setExpiryDate(new Date());
		Date result = paymentDetail.getExpiryDate();
		assertEquals(new Date(), result);
	}

//	@Test
//	public void testEquals() {
//		EqualsVerifier.forClass(PaymentDetails.class).usingGetClass().verify();
//	} 

	@Test
	public void testToString() {
		PaymentDetails act = new PaymentDetails();
		assertNotNull(act.toString());
	}
}

