package com.tfg.backend.Services;

import com.tfg.backend.Dtos.ShelterDTO;
import com.tfg.backend.Entities.Shelter;

public interface IShelterService {
	
	public Shelter createShelter (Shelter shelterDTO);
}