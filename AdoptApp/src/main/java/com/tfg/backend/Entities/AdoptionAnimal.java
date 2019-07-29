package com.tfg.backend.Entities;

import java.util.Calendar;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class AdoptionAnimal extends Animal {
	@Column
	private Long adoptionTime;
	

	

public AdoptionAnimal() {
	
}
	public AdoptionAnimal(String name, Genre genre, String description, Calendar birthDate, String health_comment,
			String color, String size, Boolean trained, String state, Long adoptionTime, Shelter shelter) {
		
		super(name, genre, description, birthDate, health_comment, color, size, trained, state, shelter);
		this.adoptionTime = adoptionTime;
		
	}
	
	public AdoptionAnimal(Long id, String name, Genre genre, String description, Calendar birthDate, String health_comment,
			String color, String size, Boolean trained, String state, Long adoptionTime, Shelter shelter) {
		
		super(name, genre, description, birthDate, health_comment, color, size, trained, state, shelter);
		this.adoptionTime = adoptionTime;
		this.setId_animal(id);
		
	}
	

	public Long getAdoptionTime() {
		return adoptionTime;
	}

	public void setAdoptionTime(Long adoptionTime) {
		this.adoptionTime = adoptionTime;
	}



		
}
