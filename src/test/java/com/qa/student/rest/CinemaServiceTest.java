package com.qa.student.rest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.google.gson.Gson;
import com.qa.student.model.Address;
import com.qa.student.model.Cinema;
import com.qa.student.model.Screen;
import com.qa.student.model.Staff;

@RunWith(MockitoJUnitRunner.class)
public class CinemaServiceTest {

	@InjectMocks
	CinemaService cinServ = new CinemaService();

	@Mock
	EntityManager em;

	@Mock 
	Query qry;

	Gson gs;
	
	@Test
	public void serviceCinAddTest(){
		Address add = new Address();
		
		Screen screen = new Screen();
		Set<Screen> screenss = new HashSet<Screen>();
		screenss.add(screen);
		
		Staff staff = new Staff();
		Set<Staff> staffSet = new HashSet<Staff>();
		staffSet.add(staff);
		
		Cinema cin = new Cinema();
		cin.setAddress(add);
		cin.setScreens(screenss);
		cin.setStaff(staffSet);
		cin.setCapacity(55);
		
		List<Cinema> listCin = new ArrayList<Cinema>();
		listCin.add(cin);
		Mockito.when(em.createQuery(Mockito.anyString())).thenReturn(qry);
		Mockito.when(qry.getResultList()).thenReturn(listCin);
		List<Cinema> assertList = cinServ.getAllCinemaList();
		Assert.assertEquals(assertList.get(0).getCapacity(), 55);		// CHANGE THIS ON FIRDAY TO BE GET THE LIST AND CHECK LIST OK THANKS
		Mockito.verify(em).createQuery(Mockito.anyString());		
	}
}