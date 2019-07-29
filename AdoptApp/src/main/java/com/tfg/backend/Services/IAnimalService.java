package com.tfg.backend.Services;

import java.io.IOException;
import java.util.List;

import com.tfg.backend.Dtos.AdoptionAnimalDTO;
import com.tfg.backend.Dtos.DeleteAnimalDTO;
import com.tfg.backend.Dtos.ShelterAnimalsDTO;
import com.tfg.backend.Entities.AdoptionAnimal;
import com.tfg.backend.Entities.AnimalPicture;
import com.tfg.backend.Exceptions.IncorrectValueException;

public interface IAnimalService {
	public AdoptionAnimal  addAdoptionAnimal (AdoptionAnimal animal);
	public void addAnimalPicture (AnimalPicture animalPicture);
	public List<AdoptionAnimal> getAllAdoptionAnimals();
	public AdoptionAnimalDTO editAdoptionAnimal(AdoptionAnimalDTO animal) throws IncorrectValueException;
	
	
}


