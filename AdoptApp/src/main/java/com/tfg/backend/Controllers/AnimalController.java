package com.tfg.backend.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tfg.backend.Dtos.AdoptionAnimalDTO;
import com.tfg.backend.Entities.AdoptionAnimal;
import com.tfg.backend.Entities.AnimalPicture;
import com.tfg.backend.Services.AnimalService;

import static com.tfg.backend.Dtos.AnimalConversor.toAdoptionAnimal;
import static com.tfg.backend.Dtos.AnimalConversor.toAdoptionAnimalDTO;
import static com.tfg.backend.Dtos.AnimalConversor.toAdoptionAnimalDTOList;
import static com.tfg.backend.Dtos.UserConversor.toUserDTO;

import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping("/animal/")
public class AnimalController {
		
	@Autowired
	AnimalService animalService;
	
	
	@PostMapping("/add")
	public ResponseEntity<AdoptionAnimalDTO> addAdoptionAnimal (@RequestBody AdoptionAnimalDTO adoptionAnimalDTO) throws IOException {
		
		AdoptionAnimal animal = toAdoptionAnimal(adoptionAnimalDTO);
		
		animalService.addAdoptionAnimal(animal);
		
		if(adoptionAnimalDTO.getImage() != null && adoptionAnimalDTO.getImage().toString() != "") {

			AnimalPicture animalPicture = new AnimalPicture (adoptionAnimalDTO.getImage(), adoptionAnimalDTO.getDescription(), adoptionAnimalDTO.getImageDateTime(), animal);
			animalService.addAnimalPicture(animalPicture);
		}
		
		
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(animal.getId_animal())
				.toUri();

		return ResponseEntity.created(location).body(toAdoptionAnimalDTO(animal));
		
	}
	
	@GetMapping("/getAll")
	public List<AdoptionAnimalDTO> getAllAdoptionAnimals (){
		List <AdoptionAnimal> adoptionAnimals = animalService.getAllAdoptionAnimals();
		
		return toAdoptionAnimalDTOList(adoptionAnimals);
	}

}
