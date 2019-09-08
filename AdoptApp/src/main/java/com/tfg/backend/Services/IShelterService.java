package com.tfg.backend.Services;

import com.tfg.backend.Dtos.ShelterDTO;

import java.io.IOException;
import java.util.List;

import com.tfg.backend.Dtos.AnimalDTO;
import com.tfg.backend.Dtos.DeleteAnimalDTO;
import com.tfg.backend.Dtos.ReturnedAdoptionAnimalDTO;
import com.tfg.backend.Dtos.SearchShelterAnimalsDTO;
import com.tfg.backend.Dtos.ShelterAdoptionAnimalsDTO;
import com.tfg.backend.Entities.AdoptionAnimal;
import com.tfg.backend.Entities.Animal;
import com.tfg.backend.Entities.Shelter;
import com.tfg.backend.Exceptions.ForbiddenException;
import com.tfg.backend.Exceptions.IncorrectValueException;

public interface IShelterService {

	ReturnedAdoptionAnimalDTO addAnimal(AnimalDTO animalDTO) throws IOException;

	ShelterAdoptionAnimalsDTO getShelterAdoptionAnimals(SearchShelterAnimalsDTO param) throws ForbiddenException;

	ShelterAdoptionAnimalsDTO deleteAnimal(DeleteAnimalDTO deleteAnimalDTO)
		throws ForbiddenException, IncorrectValueException;

	ReturnedAdoptionAnimalDTO editAnimal(AnimalDTO animalDTO) throws IOException;

}