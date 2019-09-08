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
import com.tfg.backend.Dtos.AdoptionAnimalInfoDTO;
import com.tfg.backend.Dtos.AnimalDTO;
import com.tfg.backend.Dtos.DeleteAnimalDTO;
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

@Service
public class AnimalService implements IAnimalService {
	
	@Autowired
	IAnimalDao animalDao;
	
	@Autowired
	IAnimalPictureDao animalPictureDao;
	
	@Autowired
	IAdoptionAnimalDao adoptionAnimalDao;
	
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

}
