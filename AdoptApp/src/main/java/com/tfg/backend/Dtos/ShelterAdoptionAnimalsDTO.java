package com.tfg.backend.Dtos;

import java.util.List;

import com.tfg.backend.Entities.AdoptionAnimal;
import com.tfg.backend.Entities.Animal;

public class ShelterAdoptionAnimalsDTO {
	
	private List<AdoptionAnimalDTO> animals;
	private String shelterName;
	
	public List<AdoptionAnimalDTO> getAnimals() {
		return animals;
	}
	public void setAnimals(List<AdoptionAnimalDTO> animals) {
		this.animals = animals;
	}
	public String getShelterName() {
		return shelterName;
	}
	public void setShelterName(String shelterName) {
		this.shelterName = shelterName;
	}
	
	

}
