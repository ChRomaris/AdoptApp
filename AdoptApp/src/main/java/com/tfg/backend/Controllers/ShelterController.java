package com.tfg.backend.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.tfg.backend.Dtos.AnimalConversor.toAdoptionAnimalDTOList;
import static com.tfg.backend.Dtos.AnimalConversor.toAnimalDTOList;
import static com.tfg.backend.Dtos.ShelterConversor.toShelter;
import static com.tfg.backend.Dtos.ShelterConversor.toShelterDTO;

import java.util.List;

import com.tfg.backend.Dtos.DeleteAnimalDTO;
import com.tfg.backend.Dtos.SearchShelterAnimalsDTO;
import com.tfg.backend.Dtos.ShelterAdoptionAnimalsDTO;
import com.tfg.backend.Dtos.ShelterDTO;
import com.tfg.backend.Entities.AdoptionAnimal;
import com.tfg.backend.Entities.Animal;
import com.tfg.backend.Entities.Shelter;
import com.tfg.backend.Exceptions.ForbiddenException;
import com.tfg.backend.Exceptions.IncorrectValueException;
import com.tfg.backend.Services.ShelterService;

@RestController
@RequestMapping("/shelter/")
public class ShelterController {
	
	@Autowired 
	ShelterService shelterService;
	
	@PostMapping("/add")
	public ShelterDTO addShelter (@RequestBody ShelterDTO shelterDTO) {
		Shelter shelter = toShelter(shelterDTO);
		
		Shelter createdShelter = shelterService.createShelter(shelter, shelterDTO.getUserToken());
		
		return toShelterDTO (createdShelter);
		
	}
	
	@PostMapping("findByUser")
	public ShelterDTO findByUser (@RequestBody String userToken) {
		String token2 = userToken.replace("{\"userToken\":","");
		String token3 = token2.replace("\"","");
		String token4 = token3.replace("}","");
		Shelter foundShelter = shelterService.findByUser(token4 );
		if (foundShelter != null) {
			return toShelterDTO (foundShelter);
		}
		else {
			return new ShelterDTO();
		}
		
	}
	
	@PostMapping("/list")		
	public ShelterAdoptionAnimalsDTO searchShelterAnimals(@RequestBody SearchShelterAnimalsDTO param){
		
		List <Animal> adoptionAnimals = shelterService.getShelterAdoptionAnimals(param)	;
		ShelterAdoptionAnimalsDTO shelterAdoptionAnimalsDTO = new ShelterAdoptionAnimalsDTO();
		shelterAdoptionAnimalsDTO.setAnimals(toAnimalDTOList(adoptionAnimals));
		
		
		return shelterAdoptionAnimalsDTO;
	}
	
	@PostMapping("/animal/delete")
	public ShelterAdoptionAnimalsDTO deleteAnimal (@RequestBody DeleteAnimalDTO param) throws ForbiddenException, IncorrectValueException {
		List <Animal> adoptionAnimals =shelterService.deleteAnimal(param);
		ShelterAdoptionAnimalsDTO shelterAdoptionAnimalsDTO = new ShelterAdoptionAnimalsDTO();
		shelterAdoptionAnimalsDTO.setAnimals(toAnimalDTOList(adoptionAnimals));
		return shelterAdoptionAnimalsDTO;
	}
	
}
