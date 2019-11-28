package com.tfg.backend.Services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.management.InstanceNotFoundException;

import static com.tfg.backend.Dtos.AnimalConversor.toLostAnimal;
import static com.tfg.backend.Dtos.PreferencesConversor.toUserPreferencesDTO;
import static com.tfg.backend.Dtos.PreferencesConversor.toPreferences;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tfg.backend.Common.JwtGenerator;
import com.tfg.backend.Common.JwtInfo;
import com.tfg.backend.Daos.IAnimalDao;
import com.tfg.backend.Daos.IAnimalPictureDao;
import com.tfg.backend.Daos.IBreedDAO;
import com.tfg.backend.Daos.ILostAnimalDAO;
import com.tfg.backend.Daos.INotificationDAO;
import com.tfg.backend.Daos.IPreferencesDAO;
import com.tfg.backend.Daos.IProfileDao;
import com.tfg.backend.Daos.IUserDao;
import com.tfg.backend.Dtos.AnimalDTO;
import com.tfg.backend.Dtos.DeleteAnimalDTO;
import com.tfg.backend.Dtos.ImageDTO;
import com.tfg.backend.Dtos.LostAnimalPageDTO;
import com.tfg.backend.Dtos.LostAnimalsPageDTO;
import com.tfg.backend.Dtos.ReturnedLostAnimalDTO;
import com.tfg.backend.Dtos.UserPreferencesDTO;
import com.tfg.backend.Entities.AnimalPicture;
import com.tfg.backend.Entities.Breed;
import com.tfg.backend.Entities.LostAnimal;
import com.tfg.backend.Entities.Notification;
import com.tfg.backend.Entities.Notification.Type;
import com.tfg.backend.Entities.Preferences;
import com.tfg.backend.Entities.Profile;
import com.tfg.backend.Entities.User;
import com.tfg.backend.Exceptions.ForbiddenException;

@Service
public class UserService implements IUserService {
    
    @Autowired
    JwtGenerator jwtGenerator ;
    
    @Autowired
    IUserDao userDAO;
    
    @Autowired
    IAnimalDao animalDAO;
    
    @Autowired
    IProfileDao profileDAO;
    
    @Autowired
    ILostAnimalDAO lostAnimalDAO;
    
    @Autowired
    IAnimalPictureDao animalPictureDAO;
    
    @Autowired
    IPreferencesDAO preferencesDAO;
    
    @Autowired
    INotificationDAO notificationDAO;
    
    @Autowired
    IBreedDAO breedDAO;

    
    @Override
    public AnimalDTO addLostAnimal(AnimalDTO animalDTO) {
	User user = getUserFromToken(animalDTO.getUserToken());
	LostAnimal lostAnimal = toLostAnimal(animalDTO);
	lostAnimal.setOwner(user);
	if(animalDTO.getLostAnimalInfoDTO().getDateTime() == null) {
	    lostAnimal.setDateTime(Calendar.getInstance());
	    animalDTO.getLostAnimalInfoDTO().setDateTime(lostAnimal.getDateTime());
	}
	
	Breed breed = breedDAO.findByName(animalDTO.getBreedName());
	lostAnimal.setBreed(breed);
	
	animalDAO.save(lostAnimal);
	
	List<Profile> profilesToNotify = profileDAO.findByLostPreferences(lostAnimal.getLatitude(), lostAnimal.getLongitude());

	profilesToNotify.forEach((profile) ->{
	   Notification notification = new Notification();
	   notification.setAnimal(lostAnimal);
	   notification.setType(Type.LOST_ADDED);
	   notification.setProfile(profile);
	   notification.setDate(Calendar.getInstance());
	   notificationDAO.save(notification);
	});
	
	
	animalDTO.setId(lostAnimal.getId_animal());
	animalDTO.getLostAnimalInfoDTO().setUser(user);
	if(!animalDTO.getImages().isEmpty()) {
	    for (ImageDTO imageDTO : animalDTO.getImages()) {
		AnimalPicture animalPicture = new AnimalPicture();
		animalPicture.setAnimal(lostAnimal);
		   animalPicture.setImage(imageDTO.getBase64());
		   animalPicture.setDateTime(Calendar.getInstance());
		   animalPicture.setDescription(animalDTO.getDescription());
		   animalPictureDAO.save(animalPicture);
		  
	    }
	    
	    animalDTO.setImage(animalDTO.getImages().get(0).getBase64());
	}
	
	return animalDTO;
    }
    
    @Override
    public LostAnimalPageDTO getUserLostAnimals (String userToken, int page){
	User user = getUserFromToken(userToken);
	Pageable firstPage = PageRequest.of(page, 5);
	List<LostAnimal> lostAnimals = lostAnimalDAO.findByOwner(user, firstPage);
	LostAnimalPageDTO lostAnimalPageDTO = new LostAnimalPageDTO();
	List<ReturnedLostAnimalDTO> returnedLostAnimals = new ArrayList<>();
	
	    for(LostAnimal lostAnimal : lostAnimals) {
		ReturnedLostAnimalDTO returnedLostAnimalDTO = new ReturnedLostAnimalDTO();
		returnedLostAnimalDTO.setId(lostAnimal.getId_animal());
		returnedLostAnimalDTO.setName(lostAnimal.getName());
		returnedLostAnimalDTO.setGenre(lostAnimal.getGenre());
		returnedLostAnimalDTO.setDescription(lostAnimal.getDescription());
		returnedLostAnimalDTO.setBreed(lostAnimal.getBreed());
		returnedLostAnimalDTO.setDateTime(lostAnimal.getDateTime());

		if(lostAnimal.getImages().iterator().hasNext()) {
		    returnedLostAnimalDTO.setImage(lostAnimal.getImages().iterator().next().getImage());
		}
		
		
		returnedLostAnimals.add(returnedLostAnimalDTO);
	
	    }
	lostAnimalPageDTO.setLostAnimals(returnedLostAnimals);
	lostAnimalPageDTO.setTotalPages(2);
	
	return lostAnimalPageDTO;
    }
    
    @Override
    public LostAnimalPageDTO deleteLostAnimal (DeleteAnimalDTO deleteAnimalDTO ) throws InstanceNotFoundException, ForbiddenException {
	User user = getUserFromToken(deleteAnimalDTO.getUserToken());
	Optional<LostAnimal> optional = lostAnimalDAO.findById(deleteAnimalDTO.getAnimalId());
	
	if(optional.isPresent()) {
	    LostAnimal lostAnimal = optional.get();
	    if(lostAnimal.getOwner().getId() == user.getId()) {
		lostAnimalDAO.delete(lostAnimal);
		return getUserLostAnimals(deleteAnimalDTO.getUserToken(),0);
	    }else {
		throw new ForbiddenException("Not Owner");
	    }
	   
	}
	else {
	    throw new InstanceNotFoundException();
	}
    }
    
    @Override
    public UserPreferencesDTO getPreferences(String token) {
	User user = getUserFromToken(token);
	Preferences preferences = user.getPreferences();
	
	return toUserPreferencesDTO(preferences);
	
    }
    
    @Override
    public UserPreferencesDTO editPreferences(UserPreferencesDTO userPreferencesDTO) throws ForbiddenException, InstanceNotFoundException {
	User user = getUserFromToken(userPreferencesDTO.getUserToken());
	Optional<Preferences> optional = preferencesDAO.findById(userPreferencesDTO.getPreferencesId());
	if(optional.isPresent()) {
		Preferences preferences = toPreferences(userPreferencesDTO);
		Breed breed = breedDAO.findByName(userPreferencesDTO.getBreedName());
		preferences.setBreed(breed);
		if(optional.get().getProfile().getId() == user.getId()) {
		    	preferences.setProfile(user);
			preferencesDAO.save(preferences);
			return toUserPreferencesDTO(preferences);
		}else {
		    throw new ForbiddenException("Usuario Invalido");
		}
	}else {
	    throw new InstanceNotFoundException();
	}
    }
    
    
    @Override
    public User getUserFromToken(String userToken) {	
	String token2 = userToken.replace("{\"userToken\":", "");
	String token3 = token2.replace("\"", "");
	String token4 = token3.replace("}", "");
	JwtInfo tokenInfo = jwtGenerator.getInfo(token4);
	
	Optional<User> user = userDAO.findById(tokenInfo.getUserId());
	
	if (user != null) {
	    return user.get();
	} else {
	    throw new NoSuchElementException();
	}
    }
    
   

}
    
    
