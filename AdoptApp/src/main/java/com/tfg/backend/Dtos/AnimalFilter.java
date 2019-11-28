package com.tfg.backend.Dtos;

import com.tfg.backend.Entities.Animal.AnimalGenre;

import com.tfg.backend.Entities.Animal.Color;
import com.tfg.backend.Entities.Animal.Size;
import com.tfg.backend.Entities.Breed;

public class AnimalFilter {
    
    private String breed;
    private String animalType;
    private AnimalGenre genre;
    private Color color;
    private Size size;
    
    public AnimalFilter() {
	super();
    }
    
    

    public String getAnimalType() {
        return animalType;
    }



    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }



    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public AnimalGenre getGenre() {
        return genre;
    }

    public void setGenre(AnimalGenre genre) {
        this.genre = genre;
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
