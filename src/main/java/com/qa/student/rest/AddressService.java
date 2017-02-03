package com.qa.student.rest;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.jboss.logging.Logger;

import com.google.gson.Gson;
import com.qa.student.model.Address;

public class AddressService {
	private static final Logger SCREENLOGGER = Logger.getLogger(Address.class);
	
	@Inject
	private EntityManager em;
	
	@Inject
	private Gson gsonParser;
	
	public void createAddress(String jsonString){
		Address address = gsonParser.fromJson(jsonString, Address.class);
		this.createAddress(address);
	}
	
	public void createAddress(Address address){
		Address checker = em.find(Address.class, address);
		if(checker != null){
			SCREENLOGGER.info("Address not added, already exists");
		} else {
			em.persist(address);
			SCREENLOGGER.info("Address added successfully");
		}
	}
	
	public Address getAddress(long id){
		Address address = em.find(Address.class, id);
		if(address == null){
			SCREENLOGGER.info("Address of given id doesn't exist");
			return null;
		} else {
			return address;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Address> getAddressAll(){
		Query query = em.createQuery("SELECT a FROM Address a");
		if(query == null){
			SCREENLOGGER.info("No Address exist");
			return null;
		} else {
			List<Address> resultList = query.getResultList();
			return resultList;
		}
	}
	
	public void removeAddress(String jsonString){
		Address address = gsonParser.fromJson(jsonString, Address.class);
		removeAddress(address);
	}
	
	public void removeAddress(Address address){
		Address checker = em.find(Address.class, address);
		if(checker == null){
			SCREENLOGGER.info("Address doesn't exist");
		} else {
			em.remove(address);
			SCREENLOGGER.info("Address removed successfully");
		}
	}
	
	public void updateAddress(String jsonString){
		Address address = gsonParser.fromJson(jsonString, Address.class);
		updateAddress(address);
	}
	
	public void updateAddress(Address address){
		Address checker = em.find(Address.class, address);
		if(checker == null){
			SCREENLOGGER.info("Address doesn't exist");
		} else {
			em.merge(address);
			SCREENLOGGER.info("Address updated successfully");
		}
	}
}