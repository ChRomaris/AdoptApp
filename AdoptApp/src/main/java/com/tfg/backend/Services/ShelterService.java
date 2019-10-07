package com.tfg.backend.Services;

import static com.tfg.backend.Dtos.AnimalConversor.toAnimalDTOList;
import static com.tfg.backend.Dtos.AnimalConversor.toAdoptionAnimal;
import static com.tfg.backend.Dtos.AnimalConversor.toReturnedAdoptionAnimalDTO;
import static com.tfg.backend.Dtos.AnimalConversor.toReturnedAdoptionAnimalDTOList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfg.backend.Common.JwtGenerator;
import com.tfg.backend.Common.JwtInfo;
import com.tfg.backend.Daos.IAnimalDao;
import com.tfg.backend.Daos.IAnimalPictureDao;
import com.tfg.backend.Daos.IShelterDAO;
import com.tfg.backend.Daos.IUserDao;
import com.tfg.backend.Dtos.AnimalDTO;
import com.tfg.backend.Dtos.DeleteAnimalDTO;
import com.tfg.backend.Dtos.ReturnedAdoptionAnimalDTO;
import com.tfg.backend.Dtos.SearchShelterAnimalsDTO;
import com.tfg.backend.Dtos.ShelterAdoptionAnimalsDTO;
import com.tfg.backend.Dtos.ShelterAnimalsDTO;
import com.tfg.backend.Entities.AdoptionAnimal;
import com.tfg.backend.Entities.Animal;
import com.tfg.backend.Entities.AnimalPicture;
import com.tfg.backend.Entities.Shelter;
import com.tfg.backend.Entities.Profile;
import com.tfg.backend.Entities.RoleType;
import com.tfg.backend.Exceptions.ForbiddenException;
import com.tfg.backend.Exceptions.IncorrectValueException;

@Service
public class ShelterService implements IShelterService {

    @Autowired
    IShelterDAO shelterDAO;

    @Autowired
    JwtGenerator jwtGenerator;

    @Autowired
    IUserDao userDAO;

    @Autowired
    IAnimalDao animalDao;

    @Autowired
    IProfileService profileService;
    
    @Autowired
    IAnimalPictureDao animalPictureDAO;
    

    @Override
    public ShelterAdoptionAnimalsDTO getShelterAdoptionAnimals(SearchShelterAnimalsDTO param) throws ForbiddenException {
	ShelterAdoptionAnimalsDTO shelterAdoptionAnimalsDTO = new ShelterAdoptionAnimalsDTO();
	Profile profile = profileService.getProfileFromToken(param.getToken());
	Optional <Shelter> optionalShelter = shelterDAO.findById(profile.getId());
	Shelter shelter = optionalShelter.get();
	shelterAdoptionAnimalsDTO.setAnimals(toReturnedAdoptionAnimalDTOList(shelter.getAnimals()));

	
	return shelterAdoptionAnimalsDTO;
    }

    @Override
    public ShelterAdoptionAnimalsDTO deleteAnimal(DeleteAnimalDTO deleteAnimalDTO)
	    throws ForbiddenException, IncorrectValueException, ForbiddenException {
	SearchShelterAnimalsDTO searchShelterAnimalsDTO = new SearchShelterAnimalsDTO();
	searchShelterAnimalsDTO.setToken(deleteAnimalDTO.getUserToken());
	
	Profile profile = profileService.getProfileFromToken(deleteAnimalDTO.getUserToken());
	if(profile != null && profile.getRole().equals(RoleType.SHELTER)) {
	    Optional<Shelter> optionalShelter = shelterDAO.findById(profile.getId());
	    Shelter shelter = optionalShelter.get();
	    Optional<Animal> animal = animalDao.findById(deleteAnimalDTO.getAnimalId());
	    if(animal.get() != null) {
		animalDao.delete(animal.get());
	    }
	}else {
	    throw new ForbiddenException();
	}
	
	return getShelterAdoptionAnimals(searchShelterAnimalsDTO);
	
    }
    
	@Override
	public ReturnedAdoptionAnimalDTO addAnimal(AnimalDTO animalDTO) throws IOException {
	    	ReturnedAdoptionAnimalDTO returnedAdoptionAnimalDTO = new ReturnedAdoptionAnimalDTO();
	    	Profile profile = profileService.getProfileFromToken(animalDTO.getUserToken());
	    	if(profile != null && profile.getRole().equals(	RoleType.SHELTER)) {
	    	    Optional <Shelter> optionalShelter = shelterDAO.findById(profile.getId());
	    	    Shelter shelter = optionalShelter.get();
	    	    animalDTO.getAdoptionAnimalInfoDTO().setShelter(shelter);
	    	    Animal animal = toAdoptionAnimal(animalDTO);
	    	    Animal returnedAnimal = animalDao.save(animal);
	    	    animalDTO.setId(returnedAnimal.getId_animal());
	    	    if(animalDTO.getImage() != null) {
	    		AnimalPicture animalPicture = new AnimalPicture();
	    		animalPicture.setAnimal(returnedAnimal);
	    		animalPicture.setImage(animalDTO.getImage());
	    		animalPicture.setDateTime(animalDTO.getImageDateTime());
	    		animalPicture.setDescription(animalDTO.getDescription());
	    		AnimalPicture returnedAnimalPicture = animalPictureDAO.save(animalPicture);
	    		animalDTO.setImage(returnedAnimalPicture.getImage());
	    	    }
	    	    
	    	    returnedAdoptionAnimalDTO = toReturnedAdoptionAnimalDTO(animalDTO);
	    	    	
	    	}

		return returnedAdoptionAnimalDTO;
	}
	
	@Override
	public ReturnedAdoptionAnimalDTO editAnimal(AnimalDTO animalDTO) throws IOException {
	    	ReturnedAdoptionAnimalDTO returnedAdoptionAnimalDTO = new ReturnedAdoptionAnimalDTO();
	    	Profile profile = profileService.getProfileFromToken(animalDTO.getUserToken());
	    	if(profile != null && profile.getRole().equals(	RoleType.SHELTER)) {
	    	    Optional <Shelter> optionalShelter = shelterDAO.findById(profile.getId());
	    	    Shelter shelter = optionalShelter.get();
	    	    animalDTO.getAdoptionAnimalInfoDTO().setShelter(shelter);
	    	    Animal animal = toAdoptionAnimal(animalDTO);
	    	    Animal returnedAnimal = animalDao.save(animal);
	    	    animalDTO.setId(returnedAnimal.getId_animal());
	    	    returnedAdoptionAnimalDTO = toReturnedAdoptionAnimalDTO(animalDTO);
	    	}

		return returnedAdoptionAnimalDTO;
	}




}
