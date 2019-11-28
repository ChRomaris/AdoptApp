package com.tfg.backend.Dtos;

import com.tfg.backend.Entities.Breed;

public class AdoptionAnimalFilterDTO {

    private Breed breed;
    private String size;

    public AdoptionAnimalFilterDTO() {
	super();
    }

    public Breed getBreed() {
	return breed;
    }

    public void setBreed(Breed breed) {
	this.breed = breed;
    }

    public String getSize() {
	return size;
    }

    public void setSize(String size) {
	this.size = size;
    }

}
