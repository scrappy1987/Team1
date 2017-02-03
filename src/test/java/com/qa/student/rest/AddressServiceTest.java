package com.qa.student.rest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.student.model.Address;

@RunWith(MockitoJUnitRunner.class)
public class AddressServiceTest {

	@InjectMocks
	AddressService showingService;
	
	@Mock
	EntityManager em;
	
	@Mock
	Query query;
	
	@Test
	public void getAddressTest() {
		List<Address> addressList = new ArrayList<Address>();
		Address anAddress = new Address();
		anAddress.setAddressLine1("some place");
		addressList.add(anAddress);
		Mockito.when(em.createQuery(Mockito.anyString())).thenReturn(query);
		Mockito.when(query.getResultList()).thenReturn(addressList);
		List<Address> addressesFound = showingService.getAddressAll();
		Assert.assertEquals(addressesFound.get(0).getAddressLine1(), "some place");
		Mockito.verify(em).createQuery(Mockito.anyString());
	}

}