package com.tfg.backend.Services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.management.InstanceNotFoundException;

import static com.tfg.backend.Dtos.AnimalConversor.toLostAnimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tfg.backend.Common.JwtGenerator;
import com.tfg.backend.Common.JwtInfo;
import com.tfg.backend.Daos.IAnimalDao;
import com.tfg.backend.Daos.IAnimalPictureDao;
import com.tfg.backend.Daos.ILostAnimalDAO;
import com.tfg.backend.Daos.IUserDao;
import com.tfg.backend.Dtos.AnimalDTO;
import com.tfg.backend.Dtos.DeleteAnimalDTO;
import com.tfg.backend.Dtos.LostAnimalPageDTO;
import com.tfg.backend.Dtos.LostAnimalsPageDTO;
import com.tfg.backend.Dtos.ReturnedLostAnimalDTO;
import com.tfg.backend.Entities.AnimalPicture;
import com.tfg.backend.Entities.LostAnimal;
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
    ILostAnimalDAO lostAnimalDAO;
    
    @Autowired
    IAnimalPictureDao animalPictureDAO;

    
    @Override
    public AnimalDTO addLostAnimal(AnimalDTO animalDTO) {
	User user = getUserFromToken(animalDTO.getUserToken());
	LostAnimal lostAnimal = toLostAnimal(animalDTO);
	lostAnimal.setOwner(user);
	if(animalDTO.getLostAnimalInfoDTO().getDateTime() == null) {
	    lostAnimal.setDateTime(Calendar.getInstance());
	    animalDTO.getLostAnimalInfoDTO().setDateTime(lostAnimal.getDateTime());
	}
	animalDAO.save(lostAnimal);
	
	animalDTO.setId(lostAnimal.getId_animal());
	animalDTO.getLostAnimalInfoDTO().setUser(user);
	if(animalDTO.getImage() != null) {
	   AnimalPicture animalPicture = new AnimalPicture();
	   animalPicture.setAnimal(lostAnimal);
	   animalPicture.setImage(animalDTO.getImage());
	   animalPicture.setDateTime(Calendar.getInstance());
	   animalPicture.setDescription(animalDTO.getDescription());
	   AnimalPicture returnedAnimalPicture = animalPictureDAO.save(animalPicture);
	   animalDTO.setImage(returnedAnimalPicture.getImage());
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
    
    
