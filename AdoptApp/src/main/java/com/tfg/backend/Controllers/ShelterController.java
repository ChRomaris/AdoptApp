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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import static com.tfg.backend.Dtos.AnimalConversor.toAdoptionAnimal;
import static com.tfg.backend.Dtos.AnimalConversor.toAnimalDTOList;
import static com.tfg.backend.Dtos.ShelterConversor.toShelter;
import static com.tfg.backend.Dtos.ShelterConversor.toShelterDTO;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Locale;

import javax.management.InstanceNotFoundException;

import com.tfg.backend.Dtos.AdoptionAnimalsPageDTO;
import com.tfg.backend.Dtos.AnimalDTO;
import com.tfg.backend.Dtos.DeleteAnimalDTO;
import com.tfg.backend.Dtos.ErrorsDTO;
import com.tfg.backend.Dtos.ReturnedAdoptionAnimalDTO;
import com.tfg.backend.Dtos.SearchShelterAnimalsDTO;
import com.tfg.backend.Dtos.ShelterAdoptionAnimalsDTO;
import com.tfg.backend.Dtos.ShelterDTO;
import com.tfg.backend.Dtos.ShelterListDTO;
import com.tfg.backend.Dtos.ShelterPreferencesDTO;
import com.tfg.backend.Dtos.UserPreferencesDTO;
import com.tfg.backend.Entities.AdoptionAnimal;
import com.tfg.backend.Entities.Animal;
import com.tfg.backend.Entities.AnimalPicture;
import com.tfg.backend.Entities.Shelter;
import com.tfg.backend.Exceptions.DuplicatedUserException;
import com.tfg.backend.Exceptions.ForbiddenException;
import com.tfg.backend.Exceptions.IncorrectValueException;
import com.tfg.backend.Services.ShelterService;

@RestController
@RequestMapping("/shelter/")
public class ShelterController {
    
    private final static String FORBIDDEN_EXCEPTION_CODE = "project.exceptions.ForbiddenException";

    @Autowired
    ShelterService shelterService;

    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(ForbiddenException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ResponseBody
    public ErrorsDTO handleForbiddenException(ForbiddenException exception, Locale locale) {
	String errorMessage = messageSource.getMessage(FORBIDDEN_EXCEPTION_CODE, null,
		FORBIDDEN_EXCEPTION_CODE, locale);
	return new ErrorsDTO(errorMessage);
    }

    @PostMapping("/list")
    public AdoptionAnimalsPageDTO searchShelterAnimals(@RequestBody SearchShelterAnimalsDTO param) throws ForbiddenException {

	AdoptionAnimalsPageDTO adoptionAnimals = shelterService.getShelterAdoptionAnimals(param);

	return adoptionAnimals;
    }
    
    @PostMapping("/animal/add")
    public ReturnedAdoptionAnimalDTO addAnimal(@RequestBody AnimalDTO animalDTO)
	    throws IOException, ForbiddenException {
	return shelterService.addAnimal(animalDTO);

    }
    
    @PostMapping("/animal/edit")
    public ReturnedAdoptionAnimalDTO editAnimal(@RequestBody AnimalDTO animalDTO)
	    throws IOException, ForbiddenException {
	return shelterService.editAnimal(animalDTO);

    }

    @PostMapping("/animal/delete")
    public AdoptionAnimalsPageDTO deleteAnimal(@RequestBody DeleteAnimalDTO param)
	    throws ForbiddenException, IncorrectValueException {
	AdoptionAnimalsPageDTO adoptionAnimals = shelterService.deleteAnimal(param);
	return adoptionAnimals;
    }

    @GetMapping("/shelterList")
    public ShelterListDTO getShelters () {
	return shelterService.getShelterList();
    }
    
    @GetMapping("/sheltersDistance")
    public ShelterListDTO getSheltersInArea(@RequestParam String userToken) {
	return shelterService.getSheltersInArea(userToken);
    }
    
    @GetMapping("/preferences")
    public ShelterPreferencesDTO getPreferences (@RequestParam String userToken) {
	return shelterService.getPreferences(userToken);
    }
    
    @PostMapping("/preferences")
    public ShelterPreferencesDTO editPreferences(@RequestBody ShelterPreferencesDTO shelterPreferencesDTO) throws InstanceNotFoundException, ForbiddenException {
	return shelterService.editPreferences(shelterPreferencesDTO);
    }
}
