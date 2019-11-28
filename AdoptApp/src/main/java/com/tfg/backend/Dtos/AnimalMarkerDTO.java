package com.tfg.backend.Dtos;

import java.util.Calendar;

import com.tfg.backend.Entities.Breed;


public class AnimalMarkerDTO {
    Long id;
    String name;
    Breed breed;
    Calendar birthDate;
    String description;
    double distance;
    String image;
    Float latitude;
    Float longitude;
    
    public AnimalMarkerDTO() {
	super();
    }
    
    
    
    
    public Breed getBreed() {
        return breed;
    }




    public void setBreed(Breed breed) {
        this.breed = breed;
    }




    public String getImage() {
        return image;
    }




    public void setImage(String image) {
        this.image = image;
    }




    public String getDescription() {
        return description;
    }




    public void setDescription(String description) {
        this.description = description;
    }




    public Float getLatitude() {
        return latitude;
    }


    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }


    public Float getLongitude() {
        return longitude;
    }


    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getDistance() {
        return distance;
    }
    public void setDistance(double distance) {
        this.distance = distance;
    }
    public Calendar getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(Calendar birthDate) {
        this.birthDate = birthDate;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }
    
    
    
    
    
}
