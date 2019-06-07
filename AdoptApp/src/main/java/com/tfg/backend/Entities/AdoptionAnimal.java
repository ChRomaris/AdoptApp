package com.tfg.backend.Entities;

import java.util.Calendar;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
@Entity
public class AdoptionAnimal extends Animal {
	@Column
	private Long adoptionTime;
	

public AdoptionAnimal() {
	
}
	public AdoptionAnimal(String name, Genre genre, String description, Calendar birthDate, String health_comment,
			String color, String size, Boolean trained, String state, Long adoptionTime) {
		
		super(name, genre, description, birthDate, health_comment, color, size, trained, state);
		this.adoptionTime = adoptionTime;
	}

	public Long getAdoptionTime() {
		return adoptionTime;
	}

	public void setAdoptionTime(Long adoptionTime) {
		this.adoptionTime = adoptionTime;
	}

		
}
