package com.tfg.backend.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfg.backend.Daos.IShelterDAO;
import com.tfg.backend.Entities.Shelter;




@Service
public class ShelterService implements IShelterService {
	
	@Autowired
	IShelterDAO iShelterDAO;

	@Override
	public Shelter createShelter(Shelter shelter) {
		
		Shelter result = iShelterDAO.save(shelter);
		
		return result;
	}
	
	

}
