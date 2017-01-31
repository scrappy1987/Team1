package com.qa.student.rest;

import org.junit.Test;

import com.qa.student.model.Customer;

import static org.junit.Assert.*;

public class CustomerTest {
	
	@Test
	public void getAccountNumTest(){
		Customer cus = new Customer();
		cus.setAccountNumber(100);
		assertEquals(cus.getAccountNumber(),100);
	}
	
	@Test
	public void getPersonIdTest(){
		Customer cus = new Customer();
		cus.setPersonID(250);
		assertEquals(cus.getPersonID(),250);
	}
	
	@Test
	public void getemailTest(){
		Customer cus = new Customer();
		cus.setEmail("testExample");
		assertEquals(cus.getEmail(),"testExample");
	}
	@Test
	public void getPhoneNumTest(){
		Customer cus = new Customer();
		cus.setPhoneNum(123456789);
		assertEquals(cus.getPhoneNum(),123456789);
	}
	
}