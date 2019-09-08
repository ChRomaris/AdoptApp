package com.tfg.backend.Dtos;

import java.util.List;

import com.tfg.backend.Entities.AdoptionAnimal;
import com.tfg.backend.Entities.Animal;

public class ShelterAdoptionAnimalsDTO {
	
	private List<ReturnedAdoptionAnimalDTO> animals;
	
	public List<ReturnedAdoptionAnimalDTO> getAnimals() {
		return animals;
	}
	public void setAnimals(List<ReturnedAdoptionAnimalDTO> animals) {
		this.animals = animals;
	}
	
	

}
