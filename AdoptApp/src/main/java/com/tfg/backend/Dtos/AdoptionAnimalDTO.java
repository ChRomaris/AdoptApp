package com.tfg.backend.Dtos;

import java.util.Calendar;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.tfg.backend.Entities.Animal.Genre;
import com.tfg.backend.Entities.AnimalPicture;

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
	private  String image;
	private String imageDescription;
	private Calendar imageDateTime;
	
	
	public AdoptionAnimalDTO() {
		super();
	}

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
	
	public AdoptionAnimalDTO(String name, Genre genre, String description, Calendar birthDate, String health_comment,
			String color, String size, Boolean trained, String state, Long adoptionTime, String image) {
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
		this.image = image;
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
