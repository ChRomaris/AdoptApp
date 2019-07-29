package com.tfg.backend.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfg.backend.Common.JwtGenerator;
import com.tfg.backend.Common.JwtInfo;
import com.tfg.backend.Daos.IAnimalDao;
import com.tfg.backend.Daos.IShelterDAO;
import com.tfg.backend.Daos.IUserDao;
import com.tfg.backend.Dtos.DeleteAnimalDTO;
import com.tfg.backend.Dtos.SearchShelterAnimalsDTO;
import com.tfg.backend.Dtos.ShelterAdoptionAnimalsDTO;
import com.tfg.backend.Dtos.ShelterAnimalsDTO;
import com.tfg.backend.Entities.Animal;
import com.tfg.backend.Entities.Shelter;
import com.tfg.backend.Entities.User;
import com.tfg.backend.Exceptions.ForbiddenException;
import com.tfg.backend.Exceptions.IncorrectValueException;




@Service
public class ShelterService implements IShelterService {
	
	@Autowired
	IShelterDAO shelterDAO;
	
	@Autowired
	JwtGenerator jwtGenerator;
	
	@Autowired
	IUserDao userDAO;
	
	@Autowired
	IAnimalDao animalDao;

	@Override
	public Shelter createShelter(Shelter shelter, String userToken) {
		JwtInfo tokenInfo = jwtGenerator.getInfo(userToken);
		Optional<User> OptionalUser = userDAO.findById(tokenInfo.getUserId());
		User user = OptionalUser.get();
		shelter.setAdmin(user);
		Shelter result = shelterDAO.save(shelter);
		return result;
	}
	
	@Override
	public Shelter findByUser ( String userToken ) {
		JwtInfo tokenInfo = jwtGenerator.getInfo(userToken);
		Optional<User> OptionalUser = userDAO.findById(tokenInfo.getUserId());
		User user = null;
		try {
			user = OptionalUser.get();
		}catch(NoSuchElementException e) {
			return null;
		}
		
		Shelter shelter = shelterDAO.findByAdmin(user);
		return shelter;
	}
	

	
	@Override
	public List<Animal> getShelterAdoptionAnimals (SearchShelterAnimalsDTO param) {
		JwtInfo tokenInfo = jwtGenerator.getInfo(param.getUserToken());
		Optional<User> OptionalUser = userDAO.findById(tokenInfo.getUserId());
		User user = null;
		try{
			user = OptionalUser.get();
		}catch (NoSuchElementException e) {
			return new ArrayList<Animal>();
		}
		Shelter shelter = shelterDAO.findByAdmin(user);
		

		
		return shelter.getAnimals();
		
		
	}
	
	@Override
	public List<Animal> deleteAnimal(DeleteAnimalDTO deleteAnimalDTO) throws ForbiddenException, IncorrectValueException {
		List<Animal> animals = new ArrayList<>();
		JwtInfo tokenInfo = jwtGenerator.getInfo(deleteAnimalDTO.getUserToken());
		Optional<User> optionalUser = userDAO.findById(tokenInfo.getUserId());
		Optional<Animal> animal = animalDao.findById(deleteAnimalDTO.getAnimalId());
		
		if (optionalUser.isPresent() && animal.isPresent()) {
			User user = optionalUser.get();
			Shelter shelter = shelterDAO.findByAdmin(user);
				if(shelter!=null) {
					if(animal.get().getShelter().getAdmin().getId() == user.getId()) {
						animalDao.delete(animal.get());
						SearchShelterAnimalsDTO searchShelterAnimalsDTO = new SearchShelterAnimalsDTO();
						searchShelterAnimalsDTO.setUserToken(deleteAnimalDTO.getUserToken());
						animals = getShelterAdoptionAnimals(searchShelterAnimalsDTO);
					}else {
						throw new ForbiddenException("El usuario no es el administrador de la asociación");
					}
				}else{
					throw new ForbiddenException("El usuario no es administrador de ninguna asociación");
				}
			}else {
				throw new IncorrectValueException("El usuario o animal son incorrectos");
			}
		
		return animals;

	}
	
	
	
	
	

}
