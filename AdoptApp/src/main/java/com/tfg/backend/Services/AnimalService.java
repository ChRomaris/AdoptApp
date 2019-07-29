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
import com.tfg.backend.Dtos.AdoptionAnimalDTO;
import com.tfg.backend.Dtos.DeleteAnimalDTO;
import com.tfg.backend.Dtos.ShelterAnimalsDTO;
import com.tfg.backend.Entities.AdoptionAnimal;
import com.tfg.backend.Entities.Animal;
import com.tfg.backend.Entities.AnimalPicture;
import com.tfg.backend.Entities.Shelter;
import com.tfg.backend.Entities.User;
import com.tfg.backend.Exceptions.IncorrectValueException;
import static com.tfg.backend.Dtos.AnimalConversor.toAdoptionAnimal;
import static com.tfg.backend.Dtos.AnimalConversor.toAdoptionAnimalDTO;
import static com.tfg.backend.Dtos.AnimalConversor.toAdoptionAnimalEdit;

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

	@Override
	public AdoptionAnimal addAdoptionAnimal(AdoptionAnimal animal) {
		animalDao.save(animal);
		return animal;
	}
	
	public AdoptionAnimalDTO getAnimalInfo(AdoptionAnimalDTO animal) throws IncorrectValueException {
		Optional<Animal> optionalAnimal = animalDao.findById(animal.getId());
		
		if(optionalAnimal.isPresent()) {
			return toAdoptionAnimalDTO((AdoptionAnimal)optionalAnimal.get());
		}else {
			throw new IncorrectValueException("El animal indicado no existe");
		}
		
	}
	
	
	
	@Override
	public void addAnimalPicture (AnimalPicture animalPicture) {
		animalPictureDao.save(animalPicture);
	}
	
	@Override
	public List<AdoptionAnimal> getAllAdoptionAnimals (){
		List<AdoptionAnimal> allAdoptionAnimals = new ArrayList<>();
		Iterator<AdoptionAnimal> iteratorAnimals = adoptionAnimalDao.findAll().iterator();
		iteratorAnimals.forEachRemaining(allAdoptionAnimals::add);
		return allAdoptionAnimals;
	}



	@Override
	public AdoptionAnimalDTO editAdoptionAnimal(AdoptionAnimalDTO animal) throws IncorrectValueException  {
		boolean isValid = validateUser (animal.getUserToken(), animal.getId());
		if (isValid) {
			try {
				AdoptionAnimal adoptionAnimal = toAdoptionAnimalEdit(animal);
				if(animal.getShelter() != null) {
					adoptionAnimal.setShelter(animal.getShelter());
				}
				else {
					adoptionAnimal.setShelter(null);
				}
				
				animalDao.save(adoptionAnimal);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return animal;
		}else {
			throw new IncorrectValueException("El animal indicado no existe");
		}
	}
	
	public boolean validateUser (String userToken, Long animalId) {
		JwtInfo jwtInfo = jwtGenerator.getInfo(userToken);
		Optional<User> optionalUser = userDao.findById(jwtInfo.getUserId());
		Optional<Animal> optionalAnimal = animalDao.findById(animalId); 
		if (optionalUser.isPresent() || optionalAnimal.isPresent()) {
			Animal animal = optionalAnimal.get();
			User user = optionalUser.get();
			Shelter shelter = shelterDao.findByAdmin(user);
			if (shelter != null) {
				if (animal.getShelter().getAdmin().getId() == shelter.getAdmin().getId()) {
					return true;
				}
				else {
					return false;
				}
			}else {
				return false;
			}
		}else {
			return false;
		}
		
	}







	

}
