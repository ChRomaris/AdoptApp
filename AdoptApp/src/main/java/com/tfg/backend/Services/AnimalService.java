package com.tfg.backend.Services;

import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.tfg.backend.Common.JwtGenerator;
import com.tfg.backend.Common.JwtInfo;
import com.tfg.backend.Daos.IAdoptionAnimalDao;
import com.tfg.backend.Daos.IAnimalDao;
import com.tfg.backend.Daos.IAnimalPictureDao;
import com.tfg.backend.Daos.ILostAnimalDAO;
import com.tfg.backend.Daos.IShelterDAO;
import com.tfg.backend.Daos.IUserDao;
import com.tfg.backend.Dtos.AdoptionAnimalFilterDTO;
import com.tfg.backend.Dtos.AdoptionAnimalInfoDTO;
import com.tfg.backend.Dtos.AdoptionAnimalsPageDTO;
import com.tfg.backend.Dtos.AnimalDTO;
import com.tfg.backend.Dtos.AnimalMarkerDTO;
import com.tfg.backend.Dtos.DeleteAnimalDTO;
import com.tfg.backend.Dtos.EnumsDTO;
import com.tfg.backend.Dtos.LostAnimalInfoDTO;
import com.tfg.backend.Dtos.LostAnimalPageDTO;
import com.tfg.backend.Dtos.LostAnimalsInAreaDTO;
import com.tfg.backend.Dtos.LostAnimalsPageDTO;
import com.tfg.backend.Dtos.ProfileDTO;
import com.tfg.backend.Dtos.ReducedAdoptionAnimalDTO;
import com.tfg.backend.Dtos.ReturnedAdoptionAnimalDTO;
import com.tfg.backend.Dtos.ReturnedLostAnimalDTO;
import com.tfg.backend.Dtos.SearchAdoptionAnimalsDTO;
import com.tfg.backend.Dtos.SearchLostAnimalsDTO;
import com.tfg.backend.Dtos.ShelterAnimalsDTO;
import com.tfg.backend.Entities.AdoptionAnimal;
import com.tfg.backend.Entities.Animal;
import com.tfg.backend.Entities.AnimalPicture;
import com.tfg.backend.Entities.LostAnimal;
import com.tfg.backend.Entities.Preferences;
import com.tfg.backend.Entities.Shelter;
import com.tfg.backend.Entities.User;
import com.tfg.backend.Entities.Profile;
import com.tfg.backend.Exceptions.IncorrectValueException;
import static com.tfg.backend.Dtos.AnimalConversor.toReducedAdoptionAnimalDTOList;
import static com.tfg.backend.Dtos.AnimalConversor.toAdoptionAnimal;
import static com.tfg.backend.Dtos.AnimalConversor.toReturnedAdoptionAnimalDTO;
import static com.tfg.backend.Dtos.AnimalConversor.toAnimalMarkerDTO;
import static com.tfg.backend.Dtos.AnimalConversor.toLostAnimalInfoDTOList;
import static com.tfg.backend.Dtos.AnimalConversor.toAnimalDTO;


@Service
public class AnimalService implements IAnimalService {
	
	@Autowired
	IAnimalDao animalDao;
	
	@Autowired
	IAnimalPictureDao animalPictureDao;
	
	@Autowired
	IAdoptionAnimalDao adoptionAnimalDao;
	
	@Autowired
	ILostAnimalDAO lostAnimalDao;
	
	@Autowired
	IProfileService profileService;
	
	@Autowired
	IUserService userService;
	
	@Autowired
	IUserDao userDao;
	
	@Autowired
	IShelterDAO shelterDao;
	
	@Autowired
	JwtGenerator jwtGenerator;



	public ReturnedAdoptionAnimalDTO getAdoptionAnimalInfo(AnimalDTO animal) throws IncorrectValueException, UnsupportedEncodingException {
		Optional<AdoptionAnimal> optionalAnimal = adoptionAnimalDao.findById(animal.getId());

		if(optionalAnimal.isPresent()) {
			return toReturnedAdoptionAnimalDTO(optionalAnimal.get());
		}else {
			throw new IncorrectValueException("El animal indicado no existe");
		}
		
	}
	
	
	@Override
	public List<AdoptionAnimal> getAllAdoptionAnimals (){
		List<AdoptionAnimal> allAdoptionAnimals = new ArrayList<>();
		Iterator<AdoptionAnimal> iteratorAnimals = adoptionAnimalDao.findAll().iterator();
		iteratorAnimals.forEachRemaining(allAdoptionAnimals::add);
		return allAdoptionAnimals;
	}
	
	@Override
	public AdoptionAnimalsPageDTO getAdoptionAnimals(SearchAdoptionAnimalsDTO searchAdoptionAnimalsDTO) {
	    AdoptionAnimalsPageDTO adoptionAnimalsPageDTO = new AdoptionAnimalsPageDTO();
	    if(searchAdoptionAnimalsDTO.getUserToken()!=null) {
		Profile profile = profileService.getProfileFromToken(searchAdoptionAnimalsDTO.getUserToken());
		Pageable page = PageRequest.of(searchAdoptionAnimalsDTO.getPage(), 5);
		List <AdoptionAnimal> adoptionAnimals = adoptionAnimalDao.searchAdoptionAnimalsByDistance(profile.getLatitude(), profile.getLongitude(), profile.getPreferences().getMaxAdoptionDistance(), page);
		List <Double> distances = adoptionAnimalDao.searchAdoptionAnimalsDistances(profile.getLatitude(), profile.getLongitude(), profile.getPreferences().getMaxAdoptionDistance(), page);
		List<ReducedAdoptionAnimalDTO> reducedAdoptionAnimals = toReducedAdoptionAnimalDTOList(adoptionAnimals);
		Iterator distanceIterator = distances.iterator();
		reducedAdoptionAnimals.forEach((reducedAdoptionAnimal)->{
		    Double distance = (Double)distanceIterator.next();
		    reducedAdoptionAnimal.setDistance(distance); 
		});
		
		adoptionAnimalsPageDTO.setAdoptionAnimals(reducedAdoptionAnimals);
		adoptionAnimalsPageDTO.setTotalPages(adoptionAnimalDao.countAdoptionAnimalsByDistance(profile.getLatitude(), profile.getLongitude(), profile.getPreferences().getMaxAdoptionDistance())/5);
	    }else {
		adoptionAnimalsPageDTO.setAdoptionAnimals(toReducedAdoptionAnimalDTOList(getAllAdoptionAnimals()));
		adoptionAnimalsPageDTO.setTotalPages(adoptionAnimalDao.countAdoptionAnimals()/5);
	    }
	    
	    return adoptionAnimalsPageDTO;
	}
	
	
	
	@Override
	public LostAnimalsPageDTO getAllLostAnimals(int page){
	    Pageable firstPage = PageRequest.of(page, 5);
	    Page<LostAnimal> lostAnimals = lostAnimalDao.findAll(firstPage);
	    LostAnimalsPageDTO lostAnimalPageDTO = new LostAnimalsPageDTO();
	    lostAnimalPageDTO.setLostAnimals(lostAnimals);
	    lostAnimalPageDTO.setActualPage(page);
	    
	    return lostAnimalPageDTO;
	    
	}
	

	@Transactional
	public LostAnimalPageDTO searchByDistance(SearchLostAnimalsDTO searchLostAnimalsDTO) throws UnsupportedEncodingException{
	    Profile profile = profileService.getProfileFromToken(searchLostAnimalsDTO.getUserToken());
	    Float profileLatitude = profile.getLatitude();
	    Float profileLongitude = profile.getLongitude();
	    Pageable page = PageRequest.of(searchLostAnimalsDTO.getPage(), 5);
	    List<ReturnedLostAnimalDTO> returnedLostAnimals = new ArrayList<>();
	    List<LostAnimal> lostAnimals = lostAnimalDao.searchLostAnimalsByDistance(profileLatitude, profileLongitude, new Double(9000), page);
	    List<Double> distances = lostAnimalDao.searchLostAnimalsDistances(profileLatitude, profileLongitude, new Double(9000), page);
	    LostAnimalPageDTO lostAnimalPageDTO = new LostAnimalPageDTO();
	    Iterator distanceIterator = distances.iterator();
	    int numerLostAnimals = lostAnimalDao.countLostAnimals(profileLatitude, profileLongitude, new Double(9000));
	    
	    for(LostAnimal lostAnimal : lostAnimals) {
		ReturnedLostAnimalDTO returnedLostAnimalDTO = new ReturnedLostAnimalDTO();
		Double distance = (Double)distanceIterator.next();
		returnedLostAnimalDTO.setId(lostAnimal.getId_animal());
		returnedLostAnimalDTO.setName(lostAnimal.getName());
		returnedLostAnimalDTO.setGenre(lostAnimal.getGenre());
		returnedLostAnimalDTO.setDescription(lostAnimal.getDescription());
		returnedLostAnimalDTO.setBreed(lostAnimal.getBreed());
		returnedLostAnimalDTO.setDistance(distance);
		returnedLostAnimalDTO.setDateTime(lostAnimal.getDateTime());
		returnedLostAnimalDTO.setOwnerUsername(lostAnimal.getOwner().getUsername());
		if(lostAnimal.getImages().iterator().hasNext()) {
		    returnedLostAnimalDTO.setImage(lostAnimal.getImages().iterator().next().getImage());
		}
		
		
		returnedLostAnimals.add(returnedLostAnimalDTO);
	
	    }
	    
	    lostAnimalPageDTO.setLostAnimals(returnedLostAnimals);
	    lostAnimalPageDTO.setTotalPages(numerLostAnimals/5);
	    
	    return lostAnimalPageDTO;
	    
	}
	
	@Override
	public LostAnimalsInAreaDTO getAnimalsInArea (String token) {
	    LostAnimalsInAreaDTO lostAnimalsInAreaDTO = new LostAnimalsInAreaDTO();
	    Profile profile = profileService.getProfileFromToken(token);
	    Double maxDistance = null;
	    maxDistance = profile.getPreferences().getMaxLostDistance();
	    List<LostAnimal> lostAnimals = lostAnimalDao.searchLostAnimalsInArea(profile.getLatitude(), profile.getLongitude(), new Double (maxDistance));
	    List<LostAnimalInfoDTO> lostAnimalInfoDTOList = toLostAnimalInfoDTOList(lostAnimals);
	    lostAnimalsInAreaDTO.setAnimals(lostAnimalInfoDTOList);
	    return lostAnimalsInAreaDTO;
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
	public List<AnimalMarkerDTO> getNearbyAdoptionAnimals(ProfileDTO profileDTO) throws UnsupportedEncodingException {
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
	
	@Override
	public EnumsDTO getEnumValues() {
	    EnumsDTO enumsDTO = new EnumsDTO();
	    enumsDTO.setBreeds(Animal.getBreeds());
	    enumsDTO.setColors(Animal.getColors());
	    enumsDTO.setGenres(Animal.getGenres());
	    enumsDTO.setSizes(Animal.getSizes());
	    enumsDTO.setAdoptionStates(AdoptionAnimal.getAdoptionStates());
	    return enumsDTO;
	}
	
	@Override
	public AnimalDTO getLostAnimalInfo(Long animalId) throws IncorrectValueException {
	  Optional<LostAnimal> optional =  lostAnimalDao.findById(animalId);
	  
	  if(optional.isPresent()) {
	      return toAnimalDTO(optional.get());
	  }else
	      throw new IncorrectValueException("El animal indicado no existe");
	}
	
	
}