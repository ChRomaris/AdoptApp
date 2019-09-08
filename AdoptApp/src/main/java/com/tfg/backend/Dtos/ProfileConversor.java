package com.tfg.backend.Dtos;

import com.tfg.backend.Entities.Profile;
import com.tfg.backend.Entities.RoleType;
import com.tfg.backend.Entities.Shelter;
import com.tfg.backend.Entities.User;

import static com.tfg.backend.Dtos.UserConversor.toUserDTO;
import static com.tfg.backend.Dtos.UserConversor.toUser;
import static com.tfg.backend.Dtos.ShelterConversor.toShelterDTO;
import static com.tfg.backend.Dtos.ShelterConversor.toShelter;

public class ProfileConversor {
    
    public final static ProfileDTO toProfileDTO (Profile profile) {
        ProfileDTO profileDTO = new ProfileDTO();
        profileDTO.setId(profile.getId());
        profileDTO.setUsername(profile.getUsername());
        profileDTO.setLatitude(profile.getLatitude());
        profileDTO.setLongitude(profile.getLongitude());
        profileDTO.setPassword(profile.getPassword());
        profileDTO.setRole(profile.getRole());
        if(profile.getRole().equals(RoleType.USER)) {
            profileDTO.setUserDTO(toUserDTO((User)profile));
        }else {
            profileDTO.setShelterDTO(toShelterDTO((Shelter)profile));
        }
        
        return profileDTO;
    }
    
    public final static Profile toProfile (ProfileDTO profileDTO) {
	Profile profile = null;
	if(profileDTO.getUserDTO()!=null) {
	    profileDTO.setRole(RoleType.USER);
	    profile = toUser(profileDTO.getUserDTO());
	}else {
	    profileDTO.setRole(RoleType.SHELTER);
	    profile = toShelter(profileDTO.getShelterDTO());
	}
	
	profile.setUsername(profileDTO.getUsername());
	profile.setPassword(profileDTO.getPassword());
	profile.setLatitude(profileDTO.getLatitude());
	profile.setLongitude(profileDTO.getLongitude());
	profile.setRole(profileDTO.getRole());
	
	
	return profile;
    }
   
}
