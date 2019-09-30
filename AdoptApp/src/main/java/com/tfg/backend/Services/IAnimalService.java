package com.tfg.backend.Services;

import java.io.IOException;
import java.util.List;

import com.tfg.backend.Dtos.AdoptionAnimalFilterDTO;
import com.tfg.backend.Dtos.AdoptionAnimalInfoDTO;
import com.tfg.backend.Dtos.AnimalMarkerDTO;
import com.tfg.backend.Dtos.DeleteAnimalDTO;
import com.tfg.backend.Dtos.EnumsDTO;
import com.tfg.backend.Dtos.LostAnimalsPageDTO;
import com.tfg.backend.Dtos.ProfileDTO;
import com.tfg.backend.Dtos.ShelterAnimalsDTO;
import com.tfg.backend.Entities.AdoptionAnimal;
import com.tfg.backend.Entities.Animal;
import com.tfg.backend.Entities.AnimalPicture;
import com.tfg.backend.Entities.LostAnimal;
import com.tfg.backend.Exceptions.IncorrectValueException;

public interface IAnimalService {

    List<AdoptionAnimal> getAllAdoptionAnimals();

    List<AnimalMarkerDTO> getNearbyAdoptionAnimals(ProfileDTO profile);

    List<Animal> searchAdoptionAnimalByFilter(AdoptionAnimalFilterDTO filter);

    EnumsDTO getEnumValues();

    LostAnimalsPageDTO getAllLostAnimals(int page);

}
