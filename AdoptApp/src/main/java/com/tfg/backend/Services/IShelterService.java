package com.tfg.backend.Services;

import com.tfg.backend.Dtos.ShelterDTO;

import java.util.List;

import com.tfg.backend.Dtos.DeleteAnimalDTO;
import com.tfg.backend.Dtos.SearchShelterAnimalsDTO;
import com.tfg.backend.Dtos.ShelterAdoptionAnimalsDTO;
import com.tfg.backend.Entities.Animal;
import com.tfg.backend.Entities.Shelter;
import com.tfg.backend.Exceptions.ForbiddenException;
import com.tfg.backend.Exceptions.IncorrectValueException;

public interface IShelterService {
	
	Shelter createShelter(Shelter shelter, String userToken);

	Shelter findByUser(String userToken);


	List<Animal> getShelterAdoptionAnimals(SearchShelterAnimalsDTO param);

	List<Animal> deleteAnimal(DeleteAnimalDTO deleteAnimalDTO) throws ForbiddenException, IncorrectValueException;

}