package com.tfg.backend.Dtos;

import java.util.Calendar;

import com.tfg.backend.Entities.Shelter;
import com.tfg.backend.Entities.Animal.Genre;

public class ReturnedAdoptionAnimalDTO {
	private Long id;
	private String name;
	private Genre genre;
	private String breed;
	private String description;
	private String color;
	private String size;
	private  String image;
	private String imageDescription;
	private Calendar imageDateTime;
	private Calendar birthDate;
	private String health_comment;
	private Boolean trained;
	private String state;
	private Long adoptionTime;
	private Long shelterId;
	
	
	
	public ReturnedAdoptionAnimalDTO() {
	    super();
	}
	
	
	public String getBreed() {
	    return breed;
	}


	public void setBreed(String breed) {
	    this.breed = breed;
	}


	public Long getId() {
	    return id;
	}
	public void setId(Long id) {
	    this.id = id;
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
	public String getState() {
	    return state;
	}
	public void setState(String state) {
	    this.state = state;
	}
	public Long getAdoptionTime() {
	    return adoptionTime;
	}
	public void setAdoptionTime(Long adoptionTime) {
	    this.adoptionTime = adoptionTime;
	}
	public Long getShelterId() {
	    return shelterId;
	}
	public void setShelterId(Long shelterId) {
	    this.shelterId = shelterId;
	}
	
	
}
