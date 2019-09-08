package com.tfg.backend.Dtos;

import com.tfg.backend.Entities.Shelter;

public class ShelterConversor {

    public final static Shelter toShelter(ShelterDTO shelterDTO) {
	Shelter shelter = new Shelter();
	shelter.setType(shelterDTO.getType());
	shelter.setAddress(shelterDTO.getAddress());
	shelter.setName(shelterDTO.getName());
	shelter.setPhoneNumber(shelterDTO.getPhoneNumber());
	shelter.setEmail(shelterDTO.getEmail());
	shelter.setDescription(shelterDTO.getDescription());
	return shelter;

    }

    public final static ShelterDTO toShelterDTO(Shelter shelter) {
	ShelterDTO shelterDTO = new ShelterDTO();
	shelterDTO.setType(shelter.getType());
	shelterDTO.setName(shelter.getName());
	shelterDTO.setPhoneNumber(shelter.getPhoneNumber());
	shelterDTO.setEmail(shelter.getEmail());
	shelterDTO.setAddress(shelter.getAddress());
	shelterDTO.setDescription(shelter.getDescription());

	return shelterDTO;

    }
   
}
