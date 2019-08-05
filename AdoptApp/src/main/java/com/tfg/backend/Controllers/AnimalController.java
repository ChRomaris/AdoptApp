package com.tfg.backend.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tfg.backend.Dtos.AdoptionAnimalDTO;
import com.tfg.backend.Dtos.AllAdoptionAnimalsDTO;
import com.tfg.backend.Dtos.ErrorsDTO;
import com.tfg.backend.Entities.AdoptionAnimal;
import com.tfg.backend.Entities.AnimalPicture;
import com.tfg.backend.Entities.Shelter;
import com.tfg.backend.Exceptions.ForbiddenException;
import com.tfg.backend.Exceptions.IncorrectValueException;
import com.tfg.backend.Services.AnimalService;
import com.tfg.backend.Services.ShelterService;

import static com.tfg.backend.Dtos.AnimalConversor.toAdoptionAnimal;
import static com.tfg.backend.Dtos.AnimalConversor.toAdoptionAnimalDTO;
import static com.tfg.backend.Dtos.AnimalConversor.toAdoptionAnimalDTOList;
import static com.tfg.backend.Dtos.UserConversor.toUserDTO;

import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/animal/")
public class AnimalController {

    private final static String FORBIDDEN_EXCEPTION_CODE = "project.exceptions.ForbiddenException";

    @Autowired
    AnimalService animalService;

    @Autowired
    ShelterService shelterService;
    
    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(ForbiddenException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ResponseBody
    public ErrorsDTO handleForbiddenException(ForbiddenException exception, Locale locale) {
	String errorMessage = messageSource.getMessage(FORBIDDEN_EXCEPTION_CODE, null, FORBIDDEN_EXCEPTION_CODE,
		locale);
	return new ErrorsDTO(errorMessage);
    }

    @PostMapping("/add")
    public ResponseEntity<AdoptionAnimalDTO> addAdoptionAnimal(@RequestBody AdoptionAnimalDTO adoptionAnimalDTO)
	    throws IOException, ForbiddenException {

	Shelter shelter = shelterService.findByUser(adoptionAnimalDTO.getUserToken());

	adoptionAnimalDTO.setShelter(shelter);

	AdoptionAnimal animal = toAdoptionAnimal(adoptionAnimalDTO);

	animalService.addAdoptionAnimal(animal);

	if (adoptionAnimalDTO.getImage() != null && adoptionAnimalDTO.getImage().toString() != "") {

	    AnimalPicture animalPicture = new AnimalPicture(adoptionAnimalDTO.getImage(),
		    adoptionAnimalDTO.getDescription(), adoptionAnimalDTO.getImageDateTime(), animal);
	    animalService.addAnimalPicture(animalPicture);
	}

	URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
		.buildAndExpand(animal.getId_animal()).toUri();

	return ResponseEntity.created(location).body(toAdoptionAnimalDTO(animal));

    }

    @PostMapping("/edit")
    public ResponseEntity<AdoptionAnimalDTO> editAdoptionAnimal(@RequestBody AdoptionAnimalDTO adoptionAnimalDTO)
	    throws ForbiddenException {
	try {
	    Shelter shelter = shelterService.findByUser(adoptionAnimalDTO.getUserToken());

	    adoptionAnimalDTO.setShelter(shelter);

	    AdoptionAnimalDTO modifiedAdoptionAnimal = animalService.editAdoptionAnimal(adoptionAnimalDTO);
	    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
		    .buildAndExpand(modifiedAdoptionAnimal.getId()).toUri();

	    return ResponseEntity.created(location).body(modifiedAdoptionAnimal);
	} catch (IncorrectValueException e) {
	    return null;
	}

    }

    @GetMapping("/getAll")
    public AllAdoptionAnimalsDTO getAllAdoptionAnimals() {
	List<AdoptionAnimal> adoptionAnimals = animalService.getAllAdoptionAnimals();
	AllAdoptionAnimalsDTO allAdoptionAnimalsDTO = new AllAdoptionAnimalsDTO();
	allAdoptionAnimalsDTO.setAnimales(toAdoptionAnimalDTOList(adoptionAnimals));

	return allAdoptionAnimalsDTO;

    }

    @PostMapping("/getInfo")
    public AdoptionAnimalDTO getAnimalInfo(@RequestBody AdoptionAnimalDTO animal) {
	try {
	    return animalService.getAnimalInfo(animal);
	} catch (IncorrectValueException e) {
	    return null;
	}
    }

}
