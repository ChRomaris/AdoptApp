package com.tfg.backend.Dtos;

import java.util.Calendar;

import com.tfg.backend.Entities.Animal.Breed;
import com.tfg.backend.Entities.Animal.Genre;

public class ReturnedLostAnimalDTO {
    
    private Long id;
    private String name;
    private Genre genre;
    private Breed breed;
    private String Description;
    private Double distance;
    private Calendar dateTime;
    private String image;
    
    public ReturnedLostAnimalDTO() {
	super();
    }
    
    
    
    public Long getId() {
        return id;
    }



    public void setId(Long id) {
        this.id = id;
    }



    public String getImage() {
        return image;
    }



    public void setImage(String image) {
        this.image = image;
    }



    public Calendar getDateTime() {
        return dateTime;
    }



    public void setDateTime(Calendar dateTime) {
        this.dateTime = dateTime;
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

    public Breed getBreed() {
        return breed;
    }

    public void setBreed(Breed breed) {
        this.breed = breed;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }
    

}
