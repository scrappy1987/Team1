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

import com.qa.student.model.Showing;

@RunWith(MockitoJUnitRunner.class)
public class ShowingServiceTest {

	@InjectMocks
	ShowingService showingService;
	
	@Mock
	EntityManager em;
	
	@Mock
	Query query;
	
	@Test
	public void getShowingTest() {
		List<Showing> showingList = new ArrayList<Showing>();
		Showing aShowing = new Showing();
		aShowing.setShowingDuration(180);
		showingList.add(aShowing);
		Mockito.when(em.createQuery(Mockito.anyString())).thenReturn(query);
		Mockito.when(query.getResultList()).thenReturn(showingList);
		List<Showing> screensFound = showingService.getShowingAll();
		Assert.assertEquals(screensFound.get(0).getShowingDuration(), 180);
		Mockito.verify(em).createQuery(Mockito.anyString());
	}

}