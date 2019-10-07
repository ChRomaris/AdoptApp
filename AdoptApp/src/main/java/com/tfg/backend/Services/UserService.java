package com.tfg.backend.Services;

import java.util.Calendar;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static com.tfg.backend.Dtos.AnimalConversor.toLostAnimal;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfg.backend.Common.JwtGenerator;
import com.tfg.backend.Common.JwtInfo;
import com.tfg.backend.Daos.IAnimalDao;
import com.tfg.backend.Daos.IAnimalPictureDao;
import com.tfg.backend.Daos.IUserDao;
import com.tfg.backend.Dtos.AnimalDTO;
import com.tfg.backend.Entities.AnimalPicture;
import com.tfg.backend.Entities.LostAnimal;
import com.tfg.backend.Entities.Profile;
import com.tfg.backend.Entities.User;

@Service
public class UserService implements IUserService {
    
    @Autowired
    JwtGenerator jwtGenerator ;
    
    @Autowired
    IUserDao userDAO;
    
    @Autowired
    IAnimalDao animalDAO;
    
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
	    }
	
	return animalDTO;
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
    
    
