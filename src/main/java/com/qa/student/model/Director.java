package com.qa.student.model;

import java.util.ArrayList;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Director {
	
	@Id
	@GeneratedValue
	int director_id;
	@NotNull
	String first_name;
	@NotNull
	String surname;
	
	//constructor
	public Director(){
		
	}
	
	//person
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idPerson", nullable = false)
	@NotNull
	private Person person;
	
	///many to many join with movie
	@ManyToMany(cascade= CascadeType.ALL)
	@JoinTable(name="Film_Director_Join",joinColumns =
	{@JoinColumn(name ="director_id",nullable = false)},
	inverseJoinColumns = {@JoinColumn(name = "film_id", nullable = false)})
	private ArrayList<Movie> movies = new ArrayList<Movie>();
	
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public ArrayList<Movie> getMovies() {
		return movies;
	}

	public void setMovies(ArrayList<Movie> movies) {
		this.movies = movies;
	}

	public int getDirector_id() {
		return director_id;
	}

	public void setDirector_id(int director_id) {
		this.director_id = director_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
}