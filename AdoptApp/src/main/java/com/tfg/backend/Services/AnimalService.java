package com.tfg.backend.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfg.backend.Daos.IAnimalDao;
import com.tfg.backend.Entities.AdoptionAnimal;

@Service
public class AnimalService implements IAnimalService {
	
	@Autowired
	IAnimalDao animalDao;

	@Override
	public AdoptionAnimal addAdoptionAnimal(AdoptionAnimal animal) {
		animalDao.save(animal);
		return animal;
	}
	
	

}
