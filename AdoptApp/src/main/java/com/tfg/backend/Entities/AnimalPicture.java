package com.tfg.backend.Entities;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class AnimalPicture {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long AnimalPictureId;
	
	@Column (length = 500000)
	private String image;
	
	@Column
	private String description;
	
	@Column 
	private Calendar dateTime;
	
	@JsonBackReference
	@ManyToOne 
	@JoinColumn (name = "id_animal")
	private Animal animal;
	
	public AnimalPicture() {
		super();
	}
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}


	public long getAnimalPictureId() {
		return AnimalPictureId;
	}

	public void setAnimalPictureId(long animalPictureId) {
		AnimalPictureId = animalPictureId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Calendar getDateTime() {
		return dateTime;
	}

	public void setDateTime(Calendar dateTime) {
		this.dateTime = dateTime;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}








	
	
}
