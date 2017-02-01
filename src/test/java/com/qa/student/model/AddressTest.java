package com.qa.student.model;

import static org.junit.Assert.*;
import nl.jqno.equalsverifier.EqualsVerifier;

import org.junit.Test;

import com.qa.student.model.Address;

public class AddressTest {

	@Test
	public void getAddressLine1Test() {
		Address a = new Address();
		equals(a.getAddressLine1());
	}

	@Test
	public void setAddressLine1Test() {
		Address a = new Address();
		a.setAddressLine1("");
		assertNotEquals(a.getAddressLine1(), null);
	}

	@Test
	public void getAddressLine2Test() {
		Address a = new Address();
		equals(a.getAddressLine2());
	}

	@Test
	public void setAddressLine2Test() {
		Address a = new Address();
		a.setAddressLine2("");
		assertNotEquals(a.getAddressLine2(), null);
	}

	@Test
	public void getCountyTest() {
		Address a = new Address();
		equals(a.getCounty());
	}

	@Test
	public void setCountyTest() {
		Address a = new Address();
		a.setCounty("");
		assertNotEquals(a.getCounty(), null);
	}

	@Test
	public void getCountryTest() {
		Address a = new Address();
		equals(a.getCountry());
	}

	@Test
	public void setCountryTest() {
		Address a = new Address();
		a.setCountry("");
		assertNotEquals(a.getCountry(), null);
	}

	@Test
	public void getPostcodeTest() {
		Address a = new Address();
		equals(a.getPostcode());
	}

	@Test
	public void setPostcodeTest() {
		Address a = new Address();
		a.setPostcode("");
		assertNotEquals(a.getPostcode(), null);
	}

	@Test
	public void ToStringTest() {
		Address c = new Address();
		assertNotNull(c.toString());
	}

	@Test
	public void hashcodeTest() {
		Address c = new Address();
		assertNotNull(c.hashCode());
	}

	@Test
	public void equals() {
		EqualsVerifier.forClass(Address.class).usingGetClass().verify();

	}
}
