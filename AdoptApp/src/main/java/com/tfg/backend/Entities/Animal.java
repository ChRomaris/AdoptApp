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
	private String breed;
	@Column
	private String description;
	@Column
	private String color;
	@Column
	private String size;
	@JsonManagedReference
	@OneToMany(mappedBy = "animal", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<AnimalPicture> images;
	
	
	public Animal() {
		
	}
	
	
	

	public String getBreed() {
	    return breed;
	}




	public void setBreed(String breed) {
	    this.breed = breed;
	}




	public Set<AnimalPicture> getImages() {
		return images;
	}

	public void setImages(Set<AnimalPicture> images) {
		this.images = images;
	}

	public long getId_animal() {
		return id_animal;
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
	
	
	
}
