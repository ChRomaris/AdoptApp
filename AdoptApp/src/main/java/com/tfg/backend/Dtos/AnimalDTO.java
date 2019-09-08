package com.tfg.backend.Dtos;

import java.util.Calendar;

import com.tfg.backend.Entities.Shelter;
import com.tfg.backend.Entities.Animal.Genre;

public class AnimalDTO {
	private Long id;
	private String name;
	private Genre genre;
	private String description;
	private String color;
	private String size;
	private  String image;
	private String imageDescription;
	private Calendar imageDateTime;
	private String userToken;
	private AdoptionAnimalInfoDTO adoptionAnimalInfoDTO;
	
	
	public AnimalDTO() {
		super();
	}
	
	public String getUserToken() {
		return userToken;
	}

	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getImageDescription() {
		return imageDescription;
	}



	public void setImageDescription(String imageDescription) {
		this.imageDescription = imageDescription;
	}



	public Calendar getImageDateTime() {
		return imageDateTime;
	}



	public void setImageDateTime(Calendar imageDateTime) {
		this.imageDateTime = imageDateTime;
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

	public Long getId() {
	    return id;
	}

	public void setId(Long id) {
	    this.id = id;
	}

	public AdoptionAnimalInfoDTO getAdoptionAnimalInfoDTO() {
	    return adoptionAnimalInfoDTO;
	}

	public void setAdoptionAnimalInfoDTO(AdoptionAnimalInfoDTO adoptionAnimalInfoDTO) {
	    this.adoptionAnimalInfoDTO = adoptionAnimalInfoDTO;
	}
	


}
