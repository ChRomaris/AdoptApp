package com.tfg.backend.Dtos;

import java.util.Calendar;

import com.tfg.backend.Entities.Animal.Genre;

public class AdoptionAnimalDTO {
	
	private String name;
	private Genre genre;
	private String description;
	private Calendar birthDate;
	private String health_comment;
	private String color;
	private String size;
	private Boolean trained;
	private String state;
	private Long adoptionTime;
	
	
	public AdoptionAnimalDTO(String name, Genre genre, String description, Calendar birthDate, String health_comment,
			String color, String size, Boolean trained, String state, Long adoptionTime) {
		super();
		this.name = name;
		this.genre = genre;
		this.description = description;
		this.birthDate = birthDate;
		this.health_comment = health_comment;
		this.color = color;
		this.size = size;
		this.trained = trained;
		this.state = state;
		this.adoptionTime = adoptionTime;
	}
	
	public Long getAdoptionTime() {
		return adoptionTime;
	}
	public void setAdoptionTime(Long adoptionTime) {
		this.adoptionTime = adoptionTime;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Genre getGenre() {
		return genre;
	}
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Calendar getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Calendar birthDate) {
		this.birthDate = birthDate;
	}
	public String getHealth_comment() {
		return health_comment;
	}
	public void setHealth_comment(String health_comment) {
		this.health_comment = health_comment;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public Boolean getTrained() {
		return trained;
	}
	public void setTrained(Boolean trained) {
		this.trained = trained;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
	

}
