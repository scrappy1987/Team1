package com.qa.student.rest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.qa.student.model.Person;
import com.qa.student.model.Staff;

import org.junit.Assert;

@RunWith(MockitoJUnitRunner.class)
public class StaffServiceTest {

	@InjectMocks
	StaffService staffServ = new StaffService();

	@Mock
	EntityManager em;

	@Mock 
	Query qry;
	
	Gson gs;

	// Tests for adding staff 
	@Test
	public void serviceAddTestObj() {
		Person pers = new Person("first","last","01-01-2017");
		Staff addStaff = new Staff("testRole", pers);
		
		Mockito.when(em.createQuery(Mockito.anyString())).thenReturn(qry);
		Mockito.when(qry.getSingleResult()).thenReturn(addStaff);
		Staff checked =	gs.fromJson(staffServ.getStaff(addStaff.getIdStaff()), Staff.class);
				
		Assert.assertEquals(checked.getJobRole(), "testRole");		// CHANGE THIS ON FIRDAY TO BE GET THE LIST AND CHECK LIST OK THANKS
		
		Mockito.verify(em).createQuery(Mockito.anyString());
	}
	@Test
	public void serviceAddTestJSON() {
		
		Person pers = new Person("first","last","01-01-2017");
		Staff addStaff = new Staff("testRole", pers);
		List<Staff> listStaff = new ArrayList<Staff>();
		listStaff.add(addStaff);
		Mockito.when(em.createQuery(Mockito.anyString())).thenReturn(qry);
		Mockito.when(qry.getResultList()).thenReturn(listStaff);
		String jsonList = staffServ.getAllStaffStr();
		List<Staff> assertList = gs.fromJson(jsonList, new TypeToken<List<Staff>>(){}.getType());
		
		
		
		
		Staff checked =	gs.fromJson(staffServ.getStaff(addStaff.getIdStaff()), Staff.class);
		
		//list = gs.fromJson(String, new TypeToken<List<Staff>>(){}.getType());
		
		
		
		Assert.assertEquals(assertList.get(0).getJobRole(), "testRole");		// CHANGE THIS ON FIRDAY TO BE GET THE LIST AND CHECK LIST OK THANKS
		
		Mockito.verify(em).createQuery(Mockito.anyString());
		
		
		//List<Staff> list = gs.fromJson(String, new TypeToken<List<Staff>>(){}.getType());
		
		
	}
	@Test
	public void serviceAddTestConstr() {
		Person pers = new Person("first","last","01-01-2017");
		Staff addStaff = new Staff("testRole", pers);
		addStaff.setIdStaff(0);
		
		Mockito.when(em.createQuery(Mockito.anyString())).thenReturn(qry);
		Mockito.when(qry.getSingleResult()).thenReturn(addStaff);
		Staff checked = staffServ.getStaffObj(0 /*addStaff.getIdStaff()*/);
				
		Assert.assertEquals(checked.getJobRole(), "testRole");		// CHANGE THIS ON FIRDAY TO BE GET THE LIST AND CHECK LIST OK THANKS
		
		Mockito.verify(em).createQuery(Mockito.anyString());
		
	}
	
	@Test
	public void serviceGetAllTest() {
		Person pers = new Person("first","last","01-01-2017");
		Staff addStaff = new Staff("testRole", pers);
		List<Staff> listStaff = new ArrayList<Staff>();
		listStaff.add(addStaff);
		Mockito.when(em.createQuery(Mockito.anyString())).thenReturn(qry);
		Mockito.when(qry.getResultList()).thenReturn(listStaff);
		List<Staff> assertList = staffServ.getAllStaffList();
		//List<Staff> assertList = gs.fromJson(jsonList, new TypeToken<List<Staff>>(){}.getType());
		
		
		
		
		//Staff checked =	gs.fromJson(staffServ.getStaff(addStaff.getIdStaff()), Staff.class);
		
		//list = gs.fromJson(String, new TypeToken<List<Staff>>(){}.getType());
		
		
		
		Assert.assertEquals(assertList.get(0).getJobRole(), "testRole");		// CHANGE THIS ON FIRDAY TO BE GET THE LIST AND CHECK LIST OK THANKS
		
		Mockito.verify(em).createQuery(Mockito.anyString());
		
		
	}

	

}
