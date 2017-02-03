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

import com.qa.student.model.Screen;

@RunWith(MockitoJUnitRunner.class)
public class ScreenServiceTest {

	@InjectMocks
	ScreenService screenService;
	
	@Mock
	EntityManager em;
	
	@Mock
	Query query;
	
	@Test
	public void getScreenTest() {
		List<Screen> screenList = new ArrayList<Screen>();
		Screen aScreen = new Screen();
		aScreen.setNoPremiumSeats(50);
		screenList.add(aScreen);
		Mockito.when(em.createQuery(Mockito.anyString())).thenReturn(query);
		Mockito.when(query.getResultList()).thenReturn(screenList);
		List<Screen> screensFound = screenService.getScreenAll();
		Assert.assertEquals(screensFound.get(0).getNoPremiumSeats(), 50);
		Mockito.verify(em).createQuery(Mockito.anyString());
	}

}
