package com.tfg.backend.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tfg.backend.Daos.IAnimalDao;
import com.tfg.backend.Daos.ILocationDAO;
import com.tfg.backend.Daos.ILostAnimalDAO;
import com.tfg.backend.Dtos.LocationDTO;
import com.tfg.backend.Dtos.LocationPageRequestDTO;
import com.tfg.backend.Dtos.ReturnedLocationDTO;
import com.tfg.backend.Dtos.ReturnedLocationsDTO;
import com.tfg.backend.Dtos.ReturnedLocationsPageDTO;
import com.tfg.backend.Entities.Animal;
import com.tfg.backend.Entities.Location;
import com.tfg.backend.Entities.LostAnimal;
import com.tfg.backend.Entities.Profile;
import com.tfg.backend.Exceptions.ForbiddenException;

import static com.tfg.backend.Dtos.LocationConversor.toLocation;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class LocationService implements ILocationService {
    
    @Autowired
    IProfileService profileService;
    
    @Autowired
    ILostAnimalDAO lostAnimalDAO;
    
    @Autowired
    ILocationDAO locationDAO;
    
    @Override
    public ReturnedLocationDTO addLocation (LocationDTO locationDTO) {
	ReturnedLocationDTO returnedLocationDTO = new ReturnedLocationDTO();
	String username = null ;
	
	try {
	    Profile profile = profileService.getProfileFromToken(locationDTO.getToken()); 
	    username = profile.getUsername();
	    
	}catch(NoSuchElementException e) {
	    username = locationDTO.getUserName();
	}
	
	Optional<LostAnimal> animal = lostAnimalDAO.findById(locationDTO.getAnimalId());
	
	if(animal.isPresent()) {
	    Location location = toLocation(locationDTO);
	    location.setAnimal(animal.get());
	    location.setUserName(username); 
	    Location returnedLocation = locationDAO.save(location);
	    returnedLocationDTO.setLatitude(returnedLocation.getLatitude());
	    returnedLocationDTO.setLongitude(returnedLocation.getLongitude());
	    returnedLocationDTO.setLocationId(location.getLocationId());
	}
	
	return returnedLocationDTO;
	
    }
    
    
    public ReturnedLocationsPageDTO getLocationsPage(Long animalId, String token, int page) throws ForbiddenException {
	Pageable pageable = PageRequest.of(page, 20);
	Optional<LostAnimal> animal = lostAnimalDAO.findById(animalId);
	Profile profile = profileService.getProfileFromToken(token);
	if(animal.get().getOwner().getId() == profile.getId()) {
	    
	
	List<Location> locations = locationDAO.findByAnimal(animal.get(), pageable);
	int elementsCount = locationDAO.countByAnimal(animal.get());
	ReturnedLocationsPageDTO returnedLocationsPageDTO = new ReturnedLocationsPageDTO();
	returnedLocationsPageDTO.setLocations(locations);
	returnedLocationsPageDTO.setPageNumbers(elementsCount/20);
	return returnedLocationsPageDTO;
	}else {
	    throw new ForbiddenException(); 
	}
	
    }
    
    public ReturnedLocationsDTO getLocations (Long animalId, String token) throws ForbiddenException {
	Optional<LostAnimal> animal = lostAnimalDAO.findById(animalId);
	Profile profile = profileService.getProfileFromToken(token);
	
	if(animal.get().getOwner().getId() == profile.getId()) {
	    
	
	List<Location> locations = locationDAO.findByAnimal(animal.get());
	ReturnedLocationsDTO returnedLocationsDTO = new ReturnedLocationsDTO();
	returnedLocationsDTO.setLocations(locations);

	return returnedLocationsDTO;
	
	}else {
	    throw new ForbiddenException(); 
	}
    }
    
    
}
