package com.tfg.backend.Services;

import java.util.List;

import javax.management.InstanceNotFoundException;

import com.tfg.backend.Dtos.AnimalDTO;
import com.tfg.backend.Dtos.DeleteAnimalDTO;
import com.tfg.backend.Dtos.LostAnimalPageDTO;
import com.tfg.backend.Dtos.UserPreferencesDTO;
import com.tfg.backend.Entities.User;
import com.tfg.backend.Exceptions.ForbiddenException;

public interface IUserService {
    AnimalDTO addLostAnimal (AnimalDTO animalDTO);

    User getUserFromToken(String userToken);

    LostAnimalPageDTO getUserLostAnimals(String userToken, int page);

    LostAnimalPageDTO deleteLostAnimal(DeleteAnimalDTO deleteAnimalDTO)
	    throws InstanceNotFoundException, ForbiddenException;

    UserPreferencesDTO getPreferences(String token);

    UserPreferencesDTO editPreferences(UserPreferencesDTO UserPreferencesDTO) throws ForbiddenException, InstanceNotFoundException;
    
    
}
