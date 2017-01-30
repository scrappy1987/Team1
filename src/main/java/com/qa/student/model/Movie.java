package com.qa.student.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.Date;

@Entity
public class Movie {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long film_id;
	
	//COMMENTED OUT CODE IS POSSIBLE IMPLEMENTATION FOR RELATIONS BETWEEN FILM, DIRECTORS AND ACTORS
	/*
	@Column(nullable=false)
	@ManyToMany(cascade= CascadeType.ALL)
	@JoinTable(name="Film_Director_Join",joinColumns =
	{@JoinColumn(name ="film_id",nullable = false)},
	inverseJoinColumns = {@JoinColumn(name = "director_id", nullable = false)})
	private Director director;
	

	@Column(nullable=false)
	@ManyToMany(cascade= CascadeType.ALL)
	@JoinTable(name="Film_Actor_Join",joinColumns =
	{@JoinColumn(name ="film_id",nullable = false)},
	inverseJoinColumns = {@JoinColumn(name = "actor_id", nullable = false)})
	private Actor actor;
	*/
	
	@Column(nullable = false, length = 100)
	@Size(max = 100)
	private String title;
	
	@Column(nullable = false, length = 100)
	@Size(max = 100)
	private String genre;
	
	@Column(length = 500)
	@Size(max = 500)
	private String description;
	
	@Column(nullable = false, length = 20)
	@Size(max = 20)
	private String certification;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date releaseDate;
	
	@Column(nullable = false)
	private int duration;
	
	@Column(nullable = false, length = 30)
	@Size(max = 30)
	private String language;
	
	public Movie()
	{
		
	}
	
	public Movie(Long film_id, String title, String genre, String description,
			String certification, Date releaseDate, int duration,
			String language) {
		super();
		this.film_id = film_id;
		this.title = title;
		this.genre = genre;
		this.description = description;
		this.certification = certification;
		this.releaseDate = releaseDate;
		this.duration = duration;
		this.language = language;
	}
	
	public Movie(Long film_id, String title, String genre,
			String certification, Date releaseDate, int duration,
			String language) {
		super();
		this.film_id = film_id;
		this.title = title;
		this.genre = genre;
		this.certification = certification;
		this.releaseDate = releaseDate;
		this.duration = duration;
		this.language = language;
	}

	public Long getFilm_id() {
		return film_id;
	}

	public void setFilm_id(Long film_id) {
		this.film_id = film_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCertification() {
		return certification;
	}

	public void setCertification(String certification) {
		this.certification = certification;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@Override
	public String toString() {
		return "Movie [film_id=" + film_id + ", title=" + title + ", genre="
				+ genre + ", description=" + description + ", certification="
				+ certification + ", releaseDate=" + releaseDate
				+ ", duration=" + duration + ", language=" + language + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((certification == null) ? 0 : certification.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + duration;
		result = prime * result + ((film_id == null) ? 0 : film_id.hashCode());
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result
				+ ((language == null) ? 0 : language.hashCode());
		result = prime * result
				+ ((releaseDate == null) ? 0 : releaseDate.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		if (certification == null) {
			if (other.certification != null)
				return false;
		} else if (!certification.equals(other.certification))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (duration != other.duration)
			return false;
		if (film_id == null) {
			if (other.film_id != null)
				return false;
		} else if (!film_id.equals(other.film_id))
			return false;
		if (genre == null) {
			if (other.genre != null)
				return false;
		} else if (!genre.equals(other.genre))
			return false;
		if (language == null) {
			if (other.language != null)
				return false;
		} else if (!language.equals(other.language))
			return false;
		if (releaseDate == null) {
			if (other.releaseDate != null)
				return false;
		} else if (!releaseDate.equals(other.releaseDate))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
}
