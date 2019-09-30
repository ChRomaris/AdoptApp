package com.tfg.backend.Services;

import java.util.List;

import com.tfg.backend.Dtos.AnimalDTO;
import com.tfg.backend.Entities.User;

public interface IUserService {
    AnimalDTO addLostAnimal (AnimalDTO animalDTO);

    User getUserFromToken(String userToken);
    
    
}
