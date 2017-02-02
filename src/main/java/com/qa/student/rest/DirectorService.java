package com.qa.student.rest;

import static org.mockito.Mockito.*;

import java.util.List;


public class DirectorService {
	
	//constructor
	public DirectorService(){
		List mockedList = mock(List.class);
		
		mockedList.add("one");
		mockedList.clear();

		verify(mockedList).add("one");
		verify(mockedList).clear();
	}
}