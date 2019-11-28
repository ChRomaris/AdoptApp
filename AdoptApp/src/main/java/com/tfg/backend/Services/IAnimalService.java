package com.tfg.backend.Services;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import com.tfg.backend.Dtos.AdoptionAnimalFilterDTO;
import com.tfg.backend.Dtos.AdoptionAnimalInfoDTO;
import com.tfg.backend.Dtos.AdoptionAnimalsPageDTO;
import com.tfg.backend.Dtos.AnimalDTO;
import com.tfg.backend.Dtos.AnimalMarkerDTO;
import com.tfg.backend.Dtos.DeleteAnimalDTO;
import com.tfg.backend.Dtos.EnumsDTO;
import com.tfg.backend.Dtos.LostAnimalsInAreaDTO;
import com.tfg.backend.Dtos.LostAnimalsPageDTO;
import com.tfg.backend.Dtos.ProfileDTO;
import com.tfg.backend.Dtos.SearchAdoptionAnimalsDTO;
import com.tfg.backend.Dtos.ShelterAnimalsDTO;
import com.tfg.backend.Entities.AdoptionAnimal;
import com.tfg.backend.Entities.Animal;
import com.tfg.backend.Entities.AnimalPicture;
import com.tfg.backend.Entities.LostAnimal;
import com.tfg.backend.Exceptions.IncorrectValueException;
public interface IAnimalService {


 
    List<AnimalMarkerDTO> getNearbyAdoptionAnimals(ProfileDTO profile) throws UnsupportedEncodingException;

    List<Animal> searchAdoptionAnimalByFilter(AdoptionAnimalFilterDTO filter);


    LostAnimalsInAreaDTO getAnimalsInArea(String token);


    AnimalDTO getLostAnimalInfo(Long animalId) throws IncorrectValueException;


    AdoptionAnimalsPageDTO getAdoptionAnimals(SearchAdoptionAnimalsDTO searchAdoptionAnimalsDTO);

    List<AdoptionAnimal> getAllAdoptionAnimals();

    LostAnimalsPageDTO getAllLostAnimals(int page);

    EnumsDTO getEnumValues(String name);

    List<LostAnimal> getAllLostAnimals();


//   AdoptionAnimalsPageDTO getAdoptionAnimals(SearchAdoptionAnimalsDTO searchAdoptionAnimalsDTO);
}