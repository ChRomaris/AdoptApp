package com.tfg.backend.Dtos;

import java.util.Calendar;

import com.tfg.backend.Entities.Animal.AnimalGenre;
import com.tfg.backend.Entities.Breed;

public class ReducedAdoptionAnimalDTO {
private Long id;
private String name;
private Breed breed;
private Calendar birthDate;
private String description;
private AnimalGenre genre;
private String image;
private Double distance;


public ReducedAdoptionAnimalDTO() {
    super();
}


public Long getId() {
    return id;
}


public void setId(Long id) {
    this.id = id;
}


public Double getDistance() {
    return distance;
}

public void setDistance(Double distance) {
    this.distance = distance;
}

public String getName() {
    return name;
}
public void setName(String name) {
    this.name = name;
}
public Breed getBreed() {
    return breed;
}
public void setBreed(Breed breed) {
    this.breed = breed;
}
public Calendar getBirthDate() {
    return birthDate;
}
public void setBirthDate(Calendar birthDate) {
    this.birthDate = birthDate;
}
public String getDescription() {
    return description;
}
public void setDescription(String description) {
    this.description = description;
}
public AnimalGenre getGenre() {
    return genre;
}
public void setGenre(AnimalGenre genre) {
    this.genre = genre;
}
public String getImage() {
    return image;
}
public void setImage(String image) {
    this.image = image;
}


}
