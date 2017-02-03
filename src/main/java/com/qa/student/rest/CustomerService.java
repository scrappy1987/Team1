package com.qa.student.rest;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.google.gson.Gson;
import com.qa.student.model.Customer;

public class CustomerService {
	
	@Inject
	EntityManager em;
	
	@Inject
	Gson gson;
	
	public List<Customer> getAllCustomers()
	{
		@SuppressWarnings("unchecked")
		List<Customer> customers = em.createQuery("select c from Customer order by c.accountNumber").getResultList();
		return customers;
	}
	public Customer getCustomerWithID(int customerId)
	{
		Customer customer = em.find(Customer.class, customerId);
		return customer;
	}
	public void addCustomer(String customerString)
	{
		Customer newCustomer = gson.fromJson(customerString, Customer.class);
		em.persist(newCustomer);
	}
	public void deleteCustomer(String customerString)
	{
		Customer aCustomer = gson.fromJson(customerString,Customer.class);
		em.remove(aCustomer);
	}
	public void deleteCustomer(int accountNumber)
	{
		@SuppressWarnings("unchecked")
		List<Customer> customers = em.createQuery("select c from Cusotmer").getResultList();
		for(Customer customer : customers)
		{
			if(customer.getAccountNumber() == accountNumber)
			{
				em.remove(customer);
			}
		}
		
	}
	public String convertToJSON(List<Customer> customers)
	{
		return gson.toJson(customers,Customer.class);
	}
	public String convertToJSON(Customer customer)
	{
		return gson.toJson(customer,Customer.class);
	}
	
}
