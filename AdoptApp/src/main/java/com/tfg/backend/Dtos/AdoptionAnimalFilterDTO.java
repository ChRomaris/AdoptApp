package com.tfg.backend.Dtos;

import com.tfg.backend.Entities.Animal.Genre;

public class AdoptionAnimalFilterDTO {

    private String breed;
    private String color;
    private Genre genre;
    private String size;

    public AdoptionAnimalFilterDTO() {
	super();
    }
    
    

    public String getColor() {
        return color;
    }



    public void setColor(String color) {
        this.color = color;
    }



    public Genre getGenre() {
        return genre;
    }



    public void setGenre(Genre genre) {
        this.genre = genre;
    }



    public String getBreed() {
	return breed;
    }

    public void setBreed(String breed) {
	this.breed = breed;
    }

    public String getSize() {
	return size;
    }

    public void setSize(String size) {
	this.size = size;
    }

}
