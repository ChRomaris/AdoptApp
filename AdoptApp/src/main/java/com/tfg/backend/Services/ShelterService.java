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
    public Shelter createShelter(Shelter shelter, String userToken) throws ForbiddenException {
	User user = validateUser(userToken);
	shelter.setAdmin(user);
	Shelter result = shelterDAO.save(shelter);
	return result;
    }

    @Override
    public Shelter findByUser(String userToken) throws ForbiddenException {
	User user = validateUser(userToken);
	Shelter shelter = shelterDAO.findByAdmin(user);
	return shelter;
    }

    @Override
    public List<Animal> getShelterAdoptionAnimals(SearchShelterAnimalsDTO param) throws ForbiddenException {
	User user = validateUser(param.getUserToken());
	Shelter shelter = shelterDAO.findByAdmin(user);
	return shelter.getAnimals();

    }

    @Override
    public List<Animal> deleteAnimal(DeleteAnimalDTO deleteAnimalDTO)
	    throws ForbiddenException, IncorrectValueException {
	List<Animal> animals = new ArrayList<>();
	User user = validateUser(deleteAnimalDTO.getUserToken());
	Optional<Animal> animal = animalDao.findById(deleteAnimalDTO.getAnimalId());
	Shelter shelter = shelterDAO.findByAdmin(user);
	if (shelter != null) {
	    if (animal.get().getShelter().getAdmin().getId() == user.getId()) {
		animalDao.delete(animal.get());
		SearchShelterAnimalsDTO searchShelterAnimalsDTO = new SearchShelterAnimalsDTO();
		searchShelterAnimalsDTO.setUserToken(deleteAnimalDTO.getUserToken());
		animals = getShelterAdoptionAnimals(searchShelterAnimalsDTO);
	    } else {
		throw new ForbiddenException("El usuario no es el administrador de la asociación");
	    }
	} else {
	    throw new ForbiddenException("El usuario no es administrador de ninguna asociación");
	}
	
	return animals;
    }

    public User validateUser(String userToken) throws ForbiddenException {
	if (userToken != null) {
	    JwtInfo tokenInfo = jwtGenerator.getInfo(userToken);
	    Optional<User> optionalUser = userDAO.findById(tokenInfo.getUserId());
	    if (!optionalUser.isPresent()) {
		throw new ForbiddenException();
	    } else {
		return optionalUser.get();
	    }
	} else {
	    throw new ForbiddenException();
	}
    }

}
