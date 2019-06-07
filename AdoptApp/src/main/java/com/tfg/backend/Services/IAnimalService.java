package com.tfg.backend.Services;

import java.util.List;

import com.tfg.backend.Entities.AdoptionAnimal;
import com.tfg.backend.Entities.AnimalPicture;

public interface IAnimalService {
	public AdoptionAnimal  addAdoptionAnimal (AdoptionAnimal animal);
	public void addAnimalPicture (AnimalPicture animalPicture);
	public List<AdoptionAnimal> getAllAdoptionAnimals();
}


