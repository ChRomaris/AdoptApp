package com.tfg.backend.Services;


import static com.tfg.backend.Dtos.PreferencesConversor.toShelterPreferencesDTO;
import static com.tfg.backend.Dtos.AnimalConversor.toAnimalDTOList;
import static com.tfg.backend.Dtos.AnimalConversor.toAdoptionAnimal;
import static com.tfg.backend.Dtos.AnimalConversor.toReturnedAdoptionAnimalDTO;
import static com.tfg.backend.Dtos.AnimalConversor.toReturnedAdoptionAnimalDTOList;
import static com.tfg.backend.Dtos.PreferencesConversor.toPreferences;
import static com.tfg.backend.Dtos.PreferencesConversor.toUserPreferencesDTO;
import static com.tfg.backend.Dtos.ShelterConversor.toShelterDTOList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.management.InstanceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tfg.backend.Common.JwtGenerator;
import com.tfg.backend.Common.JwtInfo;
import com.tfg.backend.Daos.IAdoptionAnimalDao;
import com.tfg.backend.Daos.IAnimalDao;
import com.tfg.backend.Daos.IAnimalPictureDao;
import com.tfg.backend.Daos.IPreferencesDAO;
import com.tfg.backend.Daos.IShelterDAO;
import com.tfg.backend.Daos.IUserDao;
import com.tfg.backend.Dtos.AdoptionAnimalsPageDTO;
import com.tfg.backend.Dtos.AnimalDTO;
import com.tfg.backend.Dtos.DeleteAnimalDTO;
import com.tfg.backend.Dtos.ImageDTO;
import com.tfg.backend.Dtos.ReturnedAdoptionAnimalDTO;
import com.tfg.backend.Dtos.SearchShelterAnimalsDTO;
import com.tfg.backend.Dtos.ShelterAdoptionAnimalsDTO;
import com.tfg.backend.Dtos.ShelterAnimalsDTO;
import com.tfg.backend.Dtos.ShelterDTO;
import com.tfg.backend.Dtos.ShelterListDTO;
import com.tfg.backend.Dtos.ShelterPreferencesDTO;
import com.tfg.backend.Dtos.UserPreferencesDTO;
import com.tfg.backend.Entities.AdoptionAnimal;
import com.tfg.backend.Entities.Animal;
import com.tfg.backend.Entities.AnimalPicture;
import com.tfg.backend.Entities.Preferences;
import com.tfg.backend.Entities.Shelter;
import com.tfg.backend.Entities.User;
import com.tfg.backend.Entities.Profile;
import com.tfg.backend.Entities.RoleType;
import com.tfg.backend.Exceptions.ForbiddenException;
import com.tfg.backend.Exceptions.IncorrectValueException;
import static com.tfg.backend.Dtos.AnimalConversor.toReducedAdoptionAnimalDTOList;

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
    
    @Autowired 
    IPreferencesDAO preferencesDAO;
    
    @Autowired
    IAdoptionAnimalDao adoptionAnimalDAO;
    

    @Override
    public AdoptionAnimalsPageDTO getShelterAdoptionAnimals(SearchShelterAnimalsDTO param) throws ForbiddenException {
	AdoptionAnimalsPageDTO adoptionAnimalsPageDTO = new AdoptionAnimalsPageDTO();
	Shelter shelter = null;
	if(param.getToken()!=null) {
	     shelter = getShelterFromToken(param.getToken());

	}else {
	    Optional<Shelter> optionalShelter = shelterDAO.findById(param.getShelterId());
	     shelter = optionalShelter.get();	    
	}
	
	Pageable page = PageRequest.of(param.getPage(), 5);
	List<AdoptionAnimal> adoptionAnimals = adoptionAnimalDAO.searchAdoptionAnimalsByShelter(shelter.getId(), page);
	int totalPages = 0;
	if(adoptionAnimalDAO.countAdoptionAnimalsByShelter(shelter.getId())==5) {
	  totalPages = 0;
	}else {
	   totalPages = (adoptionAnimalDAO.countAdoptionAnimalsByShelter(shelter.getId())/5);
	}
	
	adoptionAnimalsPageDTO.setAdoptionAnimals(toReducedAdoptionAnimalDTOList(adoptionAnimals));
	adoptionAnimalsPageDTO.setTotalPages(totalPages);
	return adoptionAnimalsPageDTO;

    }

    @Override
    public AdoptionAnimalsPageDTO deleteAnimal(DeleteAnimalDTO deleteAnimalDTO)
	    throws ForbiddenException, IncorrectValueException, ForbiddenException {
	SearchShelterAnimalsDTO searchShelterAnimalsDTO = new SearchShelterAnimalsDTO();
	searchShelterAnimalsDTO.setToken(deleteAnimalDTO.getUserToken());
	searchShelterAnimalsDTO.setPage(0);
	
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
	    	if(!animalDTO.getImages().isEmpty()) {
		    for (ImageDTO imageDTO : animalDTO.getImages()) {
			 AnimalPicture animalPicture = new AnimalPicture();
			   animalPicture.setAnimal(returnedAnimal);
			   animalPicture.setImage(imageDTO.getBase64());
			   animalPicture.setDateTime(Calendar.getInstance());
			   animalPicture.setDescription(animalDTO.getDescription());
			   animalPictureDAO.save(animalPicture);
			  
		    }
		    
		    animalDTO.setImage(animalDTO.getImages().get(0).getBase64());
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

    public ShelterListDTO getShelterList () {
	List<Shelter> list = new ArrayList<>();
	Iterator<Shelter> iterator  = shelterDAO.findAll().iterator();
	iterator.forEachRemaining(list::add);
	return toShelterDTOList(list);
    }
    
    public ShelterListDTO getSheltersInArea(String userToken) {
	Profile profile = profileService.getProfileFromToken(userToken);
	Float profileLatitude = profile.getLatitude();
	Float profileLongitude = profile.getLongitude();
	Double maxDistance = profile.getPreferences().getMaxAdoptionDistance();
	List<Shelter> shelters = shelterDAO.getSheltersInArea(profileLongitude, profileLatitude, maxDistance );
	List<Double> distances = shelterDAO.getDistances(profileLongitude, profileLatitude, maxDistance);
	ShelterListDTO shelterListDTO = toShelterDTOList(shelters);
	
	for(int i=0; i<shelterListDTO.getShelters().size(); i++) {
	    shelterListDTO.getShelters().get(i).setDistance(distances.get(i));
	}
	
	return shelterListDTO;
	
    }
    
    @Override
    public ShelterPreferencesDTO getPreferences(String token) {
	Shelter shelter = getShelterFromToken(token);
	Preferences preferences = shelter.getPreferences();
	
	return toShelterPreferencesDTO(preferences);
	
    }
    
    @Override
    public ShelterPreferencesDTO editPreferences(ShelterPreferencesDTO shelterPreferencesDTO) throws ForbiddenException, InstanceNotFoundException {
	Shelter shelter = getShelterFromToken(shelterPreferencesDTO.getUserToken());
	Optional<Preferences> optional = preferencesDAO.findById(shelterPreferencesDTO.getPreferencesId());
	if(optional.isPresent()) {
		Preferences preferences = toPreferences(shelterPreferencesDTO);
		if(optional.get().getProfile().getId() == shelter.getId()) {
		    	preferences.setProfile(shelter);
			preferencesDAO.save(preferences);
			return toShelterPreferencesDTO(preferences);
		}else {
		    throw new ForbiddenException("Asociación Inválida");
		}
	}else {
	    throw new InstanceNotFoundException();
	}
    }
    
    @Override
    public Shelter getShelterFromToken(String userToken) {
	String token2 = userToken.replace("{\"userToken\":", "");
	String token3 = token2.replace("\"", "");
	String token4 = token3.replace("}", "");
	JwtInfo tokenInfo = jwtGenerator.getInfo(token4);
	
	Optional<Shelter> shelter = shelterDAO.findById(tokenInfo.getUserId());
	
	if (shelter != null) {
	    return shelter.get();
	} else {
	    throw new NoSuchElementException();
	}
    }
    
   

}


