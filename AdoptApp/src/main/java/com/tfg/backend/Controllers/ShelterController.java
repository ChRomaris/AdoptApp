package com.tfg.backend.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.tfg.backend.Dtos.ShelterConversor.toShelter;
import static com.tfg.backend.Dtos.ShelterConversor.toShelterDTO;


import com.tfg.backend.Dtos.ShelterDTO;
import com.tfg.backend.Entities.Shelter;
import com.tfg.backend.Services.ShelterService;

@RestController
@RequestMapping("/shelter/")
public class ShelterController {
	
	@Autowired 
	ShelterService shelterService;
	
	@PostMapping("/add")
	public ShelterDTO addShelter (@RequestBody ShelterDTO shelterDTO) {
		Shelter shelter = toShelter(shelterDTO);
		
		Shelter createdShelter = shelterService.createShelter(shelter);
		
		return toShelterDTO (createdShelter);
		
	}
}
