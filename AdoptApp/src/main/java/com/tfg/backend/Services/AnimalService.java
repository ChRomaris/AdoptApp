package com.tfg.backend.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfg.backend.Daos.IAnimalDao;
import com.tfg.backend.Daos.IAnimalPictureDao;
import com.tfg.backend.Entities.AdoptionAnimal;
import com.tfg.backend.Entities.AnimalPicture;

@Service
public class AnimalService implements IAnimalService {
	
	@Autowired
	IAnimalDao animalDao;
	
	@Autowired
	IAnimalPictureDao animalPictureDao;

	@Override
	public AdoptionAnimal addAdoptionAnimal(AdoptionAnimal animal) {
		animalDao.save(animal);
		return animal;
	}
	
	@Override
	public void addAnimalPicture (AnimalPicture animalPicture) {
		animalPictureDao.save(animalPicture);
	}
	
	

}
