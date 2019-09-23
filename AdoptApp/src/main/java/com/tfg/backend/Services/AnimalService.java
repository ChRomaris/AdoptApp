package com.tfg.backend.Services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfg.backend.Common.JwtGenerator;
import com.tfg.backend.Common.JwtInfo;
import com.tfg.backend.Daos.IAdoptionAnimalDao;
import com.tfg.backend.Daos.IAnimalDao;
import com.tfg.backend.Daos.IAnimalPictureDao;
import com.tfg.backend.Daos.IShelterDAO;
import com.tfg.backend.Daos.IUserDao;
import com.tfg.backend.Dtos.AdoptionAnimalFilterDTO;
import com.tfg.backend.Dtos.AdoptionAnimalInfoDTO;
import com.tfg.backend.Dtos.AnimalDTO;
import com.tfg.backend.Dtos.AnimalMarkerDTO;
import com.tfg.backend.Dtos.DeleteAnimalDTO;
import com.tfg.backend.Dtos.ProfileDTO;
import com.tfg.backend.Dtos.ReturnedAdoptionAnimalDTO;
import com.tfg.backend.Dtos.ShelterAnimalsDTO;
import com.tfg.backend.Entities.AdoptionAnimal;
import com.tfg.backend.Entities.Animal;
import com.tfg.backend.Entities.AnimalPicture;
import com.tfg.backend.Entities.Shelter;
import com.tfg.backend.Entities.Profile;
import com.tfg.backend.Exceptions.IncorrectValueException;
import static com.tfg.backend.Dtos.AnimalConversor.toAdoptionAnimal;
import static com.tfg.backend.Dtos.AnimalConversor.toReturnedAdoptionAnimalDTO;
import static com.tfg.backend.Dtos.AnimalConversor.toAnimalMarkerDTO;

@Service
public class AnimalService implements IAnimalService {
	
	@Autowired
	IAnimalDao animalDao;
	
	@Autowired
	IAnimalPictureDao animalPictureDao;
	
	@Autowired
	IAdoptionAnimalDao adoptionAnimalDao;
	
	@Autowired
	IProfileService profileService;
	
	@Autowired
	IUserDao userDao;
	
	@Autowired
	IShelterDAO shelterDao;
	
	@Autowired
	JwtGenerator jwtGenerator;


	
	public ReturnedAdoptionAnimalDTO getAdoptionAnimalInfo(AnimalDTO animal) throws IncorrectValueException {
		Optional<AdoptionAnimal> optionalAnimal = adoptionAnimalDao.findById(animal.getId());
		
		if(optionalAnimal.isPresent()) {
			return toReturnedAdoptionAnimalDTO(optionalAnimal.get());
		}else {
			throw new IncorrectValueException("El animal indicado no existe");
		}
		
	}
	
	
	
//	@Override
//	public void addAnimalPicture (AnimalPicture animalPicture) {
//		animalPictureDao.save(animalPicture);
//	}
//	
	@Override
	public List<AdoptionAnimal> getAllAdoptionAnimals (){
		List<AdoptionAnimal> allAdoptionAnimals = new ArrayList<>();
		Iterator<AdoptionAnimal> iteratorAnimals = adoptionAnimalDao.findAll().iterator();
		iteratorAnimals.forEachRemaining(allAdoptionAnimals::add);
		return allAdoptionAnimals;
	}
	
	
	
	
	private static double distance(double lat1, double lon1, double lat2, double lon2, String unit) {
		if ((lat1 == lat2) && (lon1 == lon2)) {
			return 0;
		}
		else {
			double theta = lon1 - lon2;
			double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
			dist = Math.acos(dist);
			dist = Math.toDegrees(dist);
			dist = dist * 60 * 1.1515;
			if (unit == "K") {
				dist = dist * 1.609344;
			} else if (unit == "N") {
				dist = dist * 0.8684;
			}
			return (dist);
		}
	}



	@Override
	public List<AnimalMarkerDTO> getNearbyAdoptionAnimals(ProfileDTO profileDTO) {
	    Profile profile = profileService.getProfileFromToken(profileDTO.getToken());
	    List<AnimalMarkerDTO> markers = new ArrayList<>();
	    if(profile != null) {
		Float userLatitude = profile.getLatitude();
		Float userLongitude = profile.getLongitude();
		
		List<AdoptionAnimal> adoptionAnimals = getAllAdoptionAnimals();
		Iterator<AdoptionAnimal> iterator  = adoptionAnimals.iterator();
		
		while(iterator.hasNext()) {
		    AdoptionAnimal animal = iterator.next();
		    double distance = distance(userLatitude,userLongitude, animal.getShelter().getLatitude(),animal.getShelter().getLongitude(), "K");
		    if(distance < 150) {
			AnimalMarkerDTO animalMarkerDTO = toAnimalMarkerDTO(animal);
			animalMarkerDTO.setDistance(distance);
			markers.add(animalMarkerDTO);
		    }
		}
	    }
	    
	    return markers;
	}



	@Override
	public List<Animal> searchAdoptionAnimalByFilter(AdoptionAnimalFilterDTO filter) {
	    List<Animal> foundAnimals = new ArrayList<>();
	    foundAnimals  = animalDao.searchAnimalsByFilter(filter.getBreed(), filter.getSize());
	    return foundAnimals;
	    
	}

}
