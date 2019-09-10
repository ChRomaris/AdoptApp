package com.tfg.backend.Dtos;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Set;

import com.tfg.backend.Entities.AdoptionAnimal;
import com.tfg.backend.Entities.Animal;
import com.tfg.backend.Entities.AnimalPicture;
//import com.tfg.backend.Services.AnimalService;
import com.tfg.backend.Entities.Shelter;
import com.tfg.backend.Entities.Animal.Genre;

import java.util.ArrayList;
import java.util.Base64;
import java.util.Calendar;
import java.util.List;

public class AnimalConversor {

    private AnimalConversor() {

    }

    public final static AdoptionAnimal toAdoptionAnimal(AnimalDTO animal) throws IOException {
	AdoptionAnimal adoptionAnimal = new AdoptionAnimal();

	adoptionAnimal.setColor(animal.getColor());
	adoptionAnimal.setDescription(animal.getDescription());
	adoptionAnimal.setGenre(animal.getGenre());
	if (animal.getId() != null)
	    adoptionAnimal.setId_animal(animal.getId());
	adoptionAnimal.setName(animal.getName());
	adoptionAnimal.setSize(animal.getSize());
	adoptionAnimal.setAdoptionTime(animal.getAdoptionAnimalInfoDTO().getAdoptionTime());
	adoptionAnimal.setBirthDate(animal.getAdoptionAnimalInfoDTO().getBirthDate());
	adoptionAnimal.setHealth_comment(animal.getAdoptionAnimalInfoDTO().getHealth_comment());
	adoptionAnimal.setShelter(animal.getAdoptionAnimalInfoDTO().getShelter());
	adoptionAnimal.setState(animal.getAdoptionAnimalInfoDTO().getState());
	adoptionAnimal.setTrained(animal.getAdoptionAnimalInfoDTO().getTrained());
	;

	return adoptionAnimal;
    }

    public final static AnimalDTO toAnimalDTO(AdoptionAnimal animal) {
	AnimalDTO animalDTO = new AnimalDTO();
	AdoptionAnimalInfoDTO adoptionAnimalInfoDTO = new AdoptionAnimalInfoDTO();
	String image = null;

	if (animal.getImages() != null && !animal.getImages().isEmpty()) {
	    Set<AnimalPicture> images = animal.getImages();
	    image = images.iterator().next().getImage();
	}

	animalDTO.setColor(animal.getColor());
	animalDTO.setDescription(animal.getDescription());
	animalDTO.setGenre(animal.getGenre());
	animalDTO.setId(animal.getId_animal());
	animalDTO.setImage(image);
	animalDTO.setName(animal.getName());
	animalDTO.setSize(animal.getSize());

	adoptionAnimalInfoDTO.setAdoptionTime(animal.getAdoptionTime());
	adoptionAnimalInfoDTO.setBirthDate(animal.getBirthDate());
	adoptionAnimalInfoDTO.setHealth_comment(animal.getHealth_comment());
	adoptionAnimalInfoDTO.setShelter(animal.getShelter());
	adoptionAnimalInfoDTO.setState(animal.getState());
	adoptionAnimalInfoDTO.setTrained(animal.getTrained());

	animalDTO.setAdoptionAnimalInfoDTO(adoptionAnimalInfoDTO);

	return animalDTO;

    }

    public final static ReturnedAdoptionAnimalDTO toReturnedAdoptionAnimalDTO(AnimalDTO animalDTO) {

	ReturnedAdoptionAnimalDTO returnedAdoptionAnimalDTO = new ReturnedAdoptionAnimalDTO();
	returnedAdoptionAnimalDTO.setId(animalDTO.getId());
	returnedAdoptionAnimalDTO.setName(animalDTO.getName());
	returnedAdoptionAnimalDTO.setGenre(animalDTO.getGenre());
	returnedAdoptionAnimalDTO.setDescription(animalDTO.getDescription());
	returnedAdoptionAnimalDTO.setColor(animalDTO.getColor());
	returnedAdoptionAnimalDTO.setSize(animalDTO.getSize());
	returnedAdoptionAnimalDTO.setImage(animalDTO.getImage());
	returnedAdoptionAnimalDTO.setImageDescription(animalDTO.getImageDescription());
	returnedAdoptionAnimalDTO.setImageDateTime(animalDTO.getImageDateTime());
	returnedAdoptionAnimalDTO.setBirthDate(animalDTO.getAdoptionAnimalInfoDTO().getBirthDate());
	returnedAdoptionAnimalDTO.setHealth_comment(animalDTO.getAdoptionAnimalInfoDTO().getHealth_comment());
	returnedAdoptionAnimalDTO.setTrained(animalDTO.getAdoptionAnimalInfoDTO().getTrained());
	returnedAdoptionAnimalDTO.setState(animalDTO.getAdoptionAnimalInfoDTO().getState());
	returnedAdoptionAnimalDTO.setAdoptionTime(animalDTO.getAdoptionAnimalInfoDTO().getAdoptionTime());
	returnedAdoptionAnimalDTO.setShelterId(animalDTO.getAdoptionAnimalInfoDTO().getShelter().getId());
	
	return returnedAdoptionAnimalDTO;
    }
    
    public final static ReturnedAdoptionAnimalDTO toReturnedAdoptionAnimalDTO(AdoptionAnimal adoptionAnimal) {

	ReturnedAdoptionAnimalDTO returnedAdoptionAnimalDTO = new ReturnedAdoptionAnimalDTO();
	returnedAdoptionAnimalDTO.setId(adoptionAnimal.getId_animal());
	returnedAdoptionAnimalDTO.setName(adoptionAnimal.getName());
	returnedAdoptionAnimalDTO.setGenre(adoptionAnimal.getGenre());
	returnedAdoptionAnimalDTO.setDescription(adoptionAnimal.getDescription());
	returnedAdoptionAnimalDTO.setColor(adoptionAnimal.getColor());
	returnedAdoptionAnimalDTO.setSize(adoptionAnimal.getSize());
	returnedAdoptionAnimalDTO.setBirthDate(adoptionAnimal.getBirthDate());
	returnedAdoptionAnimalDTO.setHealth_comment(adoptionAnimal.getHealth_comment());
	returnedAdoptionAnimalDTO.setTrained(adoptionAnimal.getTrained());
	returnedAdoptionAnimalDTO.setState(adoptionAnimal.getState());
	returnedAdoptionAnimalDTO.setAdoptionTime(adoptionAnimal.getAdoptionTime());
	returnedAdoptionAnimalDTO.setShelterId(adoptionAnimal.getShelter().getId());
	
	return returnedAdoptionAnimalDTO;
    }

    public final static List<AnimalDTO> toAnimalDTOList(List<AdoptionAnimal> adoptionAnimalList) {
	List<AnimalDTO> adoptionAnimalDTOList = new ArrayList<>();

	adoptionAnimalList.forEach((adoptionAnimal) -> adoptionAnimalDTOList.add(toAnimalDTO(adoptionAnimal)));

	return adoptionAnimalDTOList;
    }
    
    public final static List<ReturnedAdoptionAnimalDTO> toReturnedAdoptionAnimalDTOList(List<AdoptionAnimal> adoptionAnimalList) {
	List<ReturnedAdoptionAnimalDTO> returnedAdoptionAnimalDTO = new ArrayList<>();

	adoptionAnimalList.forEach((adoptionAnimal) -> returnedAdoptionAnimalDTO.add(toReturnedAdoptionAnimalDTO(adoptionAnimal)));

	return returnedAdoptionAnimalDTO;
    }
    
    public final static AnimalMarkerDTO toAnimalMarkerDTO (AdoptionAnimal animal) {
	AnimalMarkerDTO marker = new AnimalMarkerDTO();
	marker.setName(animal.getName());
	marker.setBirthDate(animal.getBirthDate());
	return marker;
	
    }
    
    
    

}
