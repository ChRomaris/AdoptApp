package com.tfg.backend.Dtos;
import java.util.Calendar;
import com.tfg.backend.Entities.Animal.Color;
import com.tfg.backend.Entities.Animal.AnimalGenre;
import com.tfg.backend.Entities.Animal.Size;
import com.tfg.backend.Entities.Breed;

public class ReturnedLostAnimalDTO {

    private Long id;
    private String name;
    private AnimalGenre genre;
    private Breed breed;
    private String Description;
    private Double distance;
    private Calendar dateTime;
    private String image;
    private String ownerUsername;
    
    
    public ReturnedLostAnimalDTO() {
	super();
    }
    
    



    public String getOwnerUsername() {
        return ownerUsername;
    }





    public void setOwnerUsername(String ownerUsername) {
        this.ownerUsername = ownerUsername;
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
    public AnimalGenre getGenre() {
        return genre;
    }
    public void setGenre(AnimalGenre genre) {
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