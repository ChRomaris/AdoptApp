package com.tfg.backend.Dtos;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

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
	shelterDTO.setId(shelter.getId());
	shelterDTO.setLatitude(shelter.getLatitude());
	shelterDTO.setLongitude(shelter.getLongitude());

	return shelterDTO;

    }
    
    public final static ShelterListDTO toShelterDTOList(List<Shelter> shelters) {
	List<ShelterDTO> shelterList = new ArrayList<>();
	ShelterListDTO shelterListDTO = new ShelterListDTO();
	
	shelters.forEach((shelter) -> {
	 
		shelterList.add(toShelterDTO(shelter));
	});
	
	shelterListDTO.setShelters(shelterList);
	
	
	return shelterListDTO;

    }
    
   
}
