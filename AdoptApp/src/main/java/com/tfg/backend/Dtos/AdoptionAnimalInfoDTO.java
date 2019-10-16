package com.tfg.backend.Dtos;

import java.util.Calendar;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.tfg.backend.Entities.AdoptionAnimal.AdoptionState;
import com.tfg.backend.Entities.Animal.Genre;
import com.tfg.backend.Entities.AnimalPicture;
import com.tfg.backend.Entities.Shelter;

public class AdoptionAnimalInfoDTO {
	
	private Calendar birthDate;
	private String health_comment;
	private Boolean trained;
	private AdoptionState state;
	private Long adoptionTime;
	private Shelter shelter;
	
	public AdoptionAnimalInfoDTO() {
		super();
	}
	

	public Shelter getShelter() {
		return shelter;
	}

	public void setShelter(Shelter shelter) {
		this.shelter = shelter;
	}

	public Long getAdoptionTime() {
		return adoptionTime;
	}
	public void setAdoptionTime(Long adoptionTime) {
		this.adoptionTime = adoptionTime;
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
	public Boolean getTrained() {
		return trained;
	}
	public void setTrained(Boolean trained) {
		this.trained = trained;
	}

	public AdoptionState getState() {
	    return state;
	}


	public void setState(AdoptionState state) {
	    this.state = state;
	}

	
	
	
	
	

}
