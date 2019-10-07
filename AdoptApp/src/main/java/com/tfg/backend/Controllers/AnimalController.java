package com.tfg.backend.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tfg.backend.Dtos.AdoptionAnimalFilterDTO;
//import com.tfg.backend.Dtos.AdoptionAnimalDTO;
import com.tfg.backend.Dtos.AllAdoptionAnimalsDTO;
import com.tfg.backend.Dtos.AnimalDTO;
import com.tfg.backend.Dtos.AnimalMarkerDTO;
import com.tfg.backend.Dtos.EnumsDTO;
import com.tfg.backend.Dtos.ErrorsDTO;
import com.tfg.backend.Dtos.LocationDTO;
import com.tfg.backend.Dtos.LocationPageRequestDTO;
import com.tfg.backend.Dtos.LostAnimalPageDTO;
import com.tfg.backend.Dtos.LostAnimalsPageDTO;
import com.tfg.backend.Dtos.ProfileDTO;
import com.tfg.backend.Dtos.ReturnedAdoptionAnimalDTO;
import com.tfg.backend.Dtos.ReturnedLocationDTO;
import com.tfg.backend.Dtos.ReturnedLocationsDTO;
import com.tfg.backend.Dtos.ReturnedLocationsPageDTO;
import com.tfg.backend.Dtos.ReturnedLostAnimalDTO;
import com.tfg.backend.Dtos.SearchLostAnimalsDTO;
import com.tfg.backend.Entities.AdoptionAnimal;
import com.tfg.backend.Entities.Animal;
import com.tfg.backend.Entities.AnimalPicture;
import com.tfg.backend.Entities.LostAnimal;
import com.tfg.backend.Entities.Shelter;
import com.tfg.backend.Exceptions.ForbiddenException;
import com.tfg.backend.Exceptions.IncorrectValueException;
import com.tfg.backend.Services.AnimalService;
import com.tfg.backend.Services.LocationService;
import com.tfg.backend.Services.ShelterService;

import static com.tfg.backend.Dtos.AnimalConversor.toAdoptionAnimal;
import static com.tfg.backend.Dtos.AnimalConversor.toReturnedAdoptionAnimalDTOList;
//import static com.tfg.backend.Dtos.AnimalConversor.toAdoptionAnimalDTO;
//import static com.tfg.backend.Dtos.AnimalConversor.toAdoptionAnimalDTOList;
import static com.tfg.backend.Dtos.UserConversor.toUserDTO;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
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
    LocationService locationService;

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

    @GetMapping("/getAll")
    public AllAdoptionAnimalsDTO getAllAdoptionAnimals() {
	List<AdoptionAnimal> adoptionAnimals = animalService.getAllAdoptionAnimals();
	AllAdoptionAnimalsDTO allAdoptionAnimalsDTO = new AllAdoptionAnimalsDTO();
	allAdoptionAnimalsDTO.setAnimales(toReturnedAdoptionAnimalDTOList(adoptionAnimals));

	return allAdoptionAnimalsDTO;

    }

    @PostMapping("/nearbyAdoptionAnimals")
    public List<AnimalMarkerDTO> getNearbyAdoptionAnimals(@RequestBody ProfileDTO profile) throws UnsupportedEncodingException {
	return animalService.getNearbyAdoptionAnimals(profile);
    }

    @PostMapping("/getInfo")
    public ReturnedAdoptionAnimalDTO getAnimalInfo(@RequestBody AnimalDTO animal) throws UnsupportedEncodingException {
	try {
	    return animalService.getAdoptionAnimalInfo(animal);
	} catch (IncorrectValueException e) {
	    return null;
	}
    }

    @PostMapping("/filterAdoptAnimals")
    public List<Animal> FilterAdoptionAnimals(@RequestBody AdoptionAnimalFilterDTO filter) {
	return animalService.searchAdoptionAnimalByFilter(filter);
    }
    
    @GetMapping("/getTypes")
    public  EnumsDTO getTypes () {
	return animalService.getEnumValues();
    }
    
    @PostMapping("/getLostAnimals")
    public LostAnimalsPageDTO getLostAnimals(@RequestParam int page) {
	return animalService.getAllLostAnimals(page);
    }
    
    @PostMapping("/addLocation")
    public  ReturnedLocationDTO addLocation(@RequestBody LocationDTO locationDTO ) {
	return locationService.addLocation(locationDTO);
    }
    
    @GetMapping("/locationsPage")
    public ReturnedLocationsPageDTO getLocations(@RequestParam Long animalId, @RequestParam String token, @RequestParam int page ) throws ForbiddenException {
	return locationService.getLocationsPage(animalId, token, page);
    }
    	
    @GetMapping("/locations")
    public ReturnedLocationsDTO getLocations(@RequestParam Long animalId, @RequestParam String token ) throws ForbiddenException {
	return locationService.getLocations(animalId,token);
    }
    
    
    
    @PostMapping("/searchByDistance")
    public LostAnimalPageDTO searchByDistance(@RequestBody SearchLostAnimalsDTO searchLostAnimalsDTO) throws UnsupportedEncodingException{
	return animalService.searchByDistance(searchLostAnimalsDTO);
    }
}
