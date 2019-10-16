package com.tfg.backend.Entities;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Animal")
@Inheritance(strategy = InheritanceType.JOINED)
public class Animal {
	
	public static enum Genre{
		MALE, FEMALE
	}
	
	public static enum Breed{
	    Affenpinscher, AfghanHound,
	    AfghanShepher,
	    AlaskanHusky,
	    AmericanEskimoDog,
	    AustrianPinscher,
	    PungsanDog,
	    RussianSalonDog,
	    WelshSpringerSpaniel,
	    Whippet,
	    YorkshireTerrier
	}
	public static enum Color{
	    BLACK, GREY, WHITE, BROWN
	}
	
	public static enum Size{
	    SMALL, MEDIUM, BIG
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_animal;
	@Column
	private String name;
	@Column
	private Genre genre;
	@Column	
	private Breed breed;
	@Column
	private String description;
	@Column
	private Color color;
	@Column
	
	private Size size;
	@JsonManagedReference
	@OneToMany(mappedBy = "animal", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<AnimalPicture> images;
	
	
	public Animal() {
		
	}
	
	public static List<Breed> getBreeds() {
	    return Arrays.asList(Breed.class.getEnumConstants());
	}
	
	public static List<Color> getColors() {
	    return Arrays.asList(Color.class.getEnumConstants());
	}
	
	public static List<Size> getSizes() {
	    return Arrays.asList(Size.class.getEnumConstants());
	}
	
	public static List<Genre> getGenres() {
	    return Arrays.asList(Genre.class.getEnumConstants());
	}
	
	public Breed getBreed() {
	    return breed;
	}




	public void setBreed(Breed breed) {
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
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public Size getSize() {
		return size;
	}
	public void setSize(Size size) {
		this.size = size;
	}
	
	
	
}
