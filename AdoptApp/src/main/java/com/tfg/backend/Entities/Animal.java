package com.tfg.backend.Entities;

import java.util.Calendar;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Animal {
	
	public enum Genre{
		MALE, FEMALE
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_animal;
	@Column
	private String name;
	@Column
	private Genre genre;
	@Column
	private String description;
	@Column
	private Calendar birthDate;
	@Column
	private String health_comment;
	@Column
	private String color;
	@Column
	private String size;
	@Column
	private Boolean trained;
	@Column
	private String state;
	
	@OneToMany(mappedBy = "animal", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<AnimalPicture> images;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="shelter", referencedColumnName = "shelter_id")
	private Shelter shelter;
	

	public Set<AnimalPicture> getImages() {
		return images;
	}

	public void setImages(Set<AnimalPicture> images) {
		this.images = images;
	}

	public long getId_animal() {
		return id_animal;
	}
	public Animal() {
		
	}
	public Animal(String name, Genre genre, String description, Calendar birthDate, String health_comment, String color,
			String size, Boolean trained, String state, Set<AnimalPicture> images) {
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
		this.images = images;
	}
	
	public Animal(String name, Genre genre, String description, Calendar birthDate, String health_comment, String color,
			String size, Boolean trained, String state, Set<AnimalPicture> images, Shelter shelter) {
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
		this.images = images;
		this.shelter = shelter;
	}

	public Animal(String name, Genre genre, String description, Calendar birthDate, String health_comment, String color,
			String size, Boolean trained, String state) {
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
	}
	
	public Animal(String name, Genre genre, String description, Calendar birthDate, String health_comment, String color,
			String size, Boolean trained, String state, Shelter shelter) {
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
		this.shelter = shelter;
	}
	public void setId_animal(long id_animal) {
		this.id_animal = id_animal;
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

	public Shelter getShelter() {
		return shelter;
	}

	public void setShelter(Shelter shelter) {
		this.shelter = shelter;
	}
	
	
	
}
