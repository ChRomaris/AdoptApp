package com.tfg.backend.Dtos;

import java.util.List;

public class LostAnimalsInAreaDTO {

    private List<ReturnedLostAnimalDTO> animals;

    public LostAnimalsInAreaDTO() {
	super();
    }

    public List<ReturnedLostAnimalDTO> getAnimals() {
        return animals;
    }

    public void setAnimals(List<ReturnedLostAnimalDTO> animals) {
        this.animals = animals;
    }
    
    
}
