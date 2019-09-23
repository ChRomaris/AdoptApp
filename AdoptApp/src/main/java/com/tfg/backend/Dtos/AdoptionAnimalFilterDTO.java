package com.tfg.backend.Dtos;

public class AdoptionAnimalFilterDTO {

    private String breed;
    private String size;

    public AdoptionAnimalFilterDTO() {
	super();
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
