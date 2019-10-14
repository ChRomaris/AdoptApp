package com.tfg.backend.Dtos;

import java.util.List;

public class LostAnimalsInAreaDTO {

    private List<LostAnimalInfoDTO> animals;

    public LostAnimalsInAreaDTO() {
	super();
    }

    public List<LostAnimalInfoDTO> getAnimals() {
        return animals;
    }

    public void setAnimals(List<LostAnimalInfoDTO> animals) {
        this.animals = animals;
    }
    
    
}
