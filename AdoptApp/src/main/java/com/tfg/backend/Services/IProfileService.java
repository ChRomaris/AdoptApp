package com.tfg.backend.Services;

import javax.management.InstanceNotFoundException;

import com.tfg.backend.Dtos.AuthenticatedUserDTO;
import com.tfg.backend.Dtos.LocationDTO;
import com.tfg.backend.Dtos.ProfileDTO;
import com.tfg.backend.Dtos.ProfileEnumsDTO;
import com.tfg.backend.Entities.User;
import com.tfg.backend.Entities.Profile;
import com.tfg.backend.Exceptions.DuplicatedUserException;
import com.tfg.backend.Exceptions.IncorrectLoginException;

public interface IProfileService {


	ProfileDTO login(String username, String password) throws IncorrectLoginException;

	Profile findById(Long userId);

	ProfileDTO setLocation(LocationDTO locationDTO);

	ProfileDTO registerProfile(ProfileDTO profileDTO);

	ProfileDTO updateProfile(ProfileDTO profileDTO) throws InstanceNotFoundException;

	Profile getProfileFromToken(String userToken);
	
	ProfileEnumsDTO getProfileEnums();

}
