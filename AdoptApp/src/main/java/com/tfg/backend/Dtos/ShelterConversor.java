package com.tfg.backend.Dtos;

import com.tfg.backend.Entities.Shelter;

public class ShelterConversor {

	public final static Shelter toShelter (ShelterDTO shelterDTO) {
		return new  Shelter (shelterDTO.getType(), shelterDTO.getName(), shelterDTO.getPhoneNumber(), shelterDTO.getEmail(), shelterDTO.getAddress(), shelterDTO.getLocation());
	}
	
	
	public final static ShelterDTO toShelterDTO (Shelter shelter) {
		return new ShelterDTO (shelter.getType(), shelter.getName(), shelter.getPhoneNumber(), shelter.getEmail(), shelter.getAddress(), shelter.getLocation());
	}
}
