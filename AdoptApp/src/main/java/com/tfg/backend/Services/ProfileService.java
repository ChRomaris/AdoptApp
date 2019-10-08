package com.tfg.backend.Services;

import java.util.NoSuchElementException;
import java.util.Optional;

import javax.management.InstanceNotFoundException;

import static com.tfg.backend.Dtos.ShelterConversor.toShelter;
import static com.tfg.backend.Dtos.ShelterConversor.toShelterDTO;
import static com.tfg.backend.Dtos.UserConversor.toUser;
import static com.tfg.backend.Dtos.UserConversor.toUserDTO;
import static com.tfg.backend.Dtos.ProfileConversor.toProfileDTO;
import static com.tfg.backend.Dtos.ProfileConversor.toProfile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tfg.backend.Common.JwtGenerator;
import com.tfg.backend.Common.JwtInfo;
import com.tfg.backend.Daos.IProfileDao;
import com.tfg.backend.Daos.IShelterDAO;
import com.tfg.backend.Daos.IUserDao;
import com.tfg.backend.Dtos.AuthenticatedUserDTO;
import com.tfg.backend.Dtos.LocationDTO;
import com.tfg.backend.Dtos.ProfileDTO;
import com.tfg.backend.Dtos.ShelterDTO;
import com.tfg.backend.Dtos.UserDTO;
import com.tfg.backend.Entities.User;
import com.tfg.backend.Entities.Profile;
import com.tfg.backend.Entities.RoleType;
import com.tfg.backend.Entities.Shelter;
import com.tfg.backend.Exceptions.DuplicatedUserException;
import com.tfg.backend.Exceptions.IncorrectLoginException;

@Service
public class ProfileService implements IProfileService {

    @Autowired
    IUserDao userDao;
    @Autowired
    IProfileDao profileDAO;
    @Autowired
    JwtGenerator tokenProvider;
    @Autowired
    private JwtGenerator jwtGenerator;

    @Override
    @Transactional
    public ProfileDTO registerProfile(ProfileDTO profileDTO) {
	Profile profile = toProfile(profileDTO);
	profileDAO.save(profile);

	// Generamos el token del perfil
	JwtInfo jwtInfo = new JwtInfo(profile.getId(), profile.getUsername(), profile.getRole());
	String token = jwtGenerator.generate(jwtInfo);

	ProfileDTO registeredProfile = toProfileDTO(profile);
	registeredProfile.setToken(token);

	// Devolvemos la información del perfil
	return registeredProfile;

    }

    @Override
    @Transactional(readOnly = true)
    public ProfileDTO login(String username, String password) throws IncorrectLoginException {
	Profile profile = profileDAO.findByUsername(username);
	ProfileDTO profileDTO = null;
	if (profile != null && profile.getPassword().equals(password)) {
	    profileDTO = toProfileDTO(profile);
	} else {
	    throw new IncorrectLoginException();
	}

	return profileDTO;
    }

    @Override
    @Transactional
    public ProfileDTO updateProfile(ProfileDTO profileDTO) throws InstanceNotFoundException {
	ProfileDTO returnedProfileDTO = new ProfileDTO();
	// Buscamos el perfil de usuario a traves del token
	Profile profile = getProfileFromToken(profileDTO.getToken());
	if (profile != null) {
	    Profile newProfile = toProfile(profileDTO);
	    newProfile.setId(profile.getId());
	    Profile returnedProfile = profileDAO.save(newProfile);
	    returnedProfileDTO = new ProfileDTO();
	    returnedProfileDTO = toProfileDTO(returnedProfile);

	    // Generamos nuevo token

	    JwtInfo jwtInfo = new JwtInfo(returnedProfile.getId(), returnedProfile.getUsername(),
		    returnedProfile.getRole());
	    String token = jwtGenerator.generate(jwtInfo);

	    returnedProfileDTO.setToken(token);

	} else {
	    // Si el perfil no existe, lanzamos una excepción
	    throw new InstanceNotFoundException();
	}

	return returnedProfileDTO;
    }

    public Profile findByUsername(String username) {
	Profile profile = profileDAO.findByUsername(username);
	return profile;
    }

    @Override
    public Profile findById(Long id) {
	Optional<Profile> optionalProfile = profileDAO.findById(id);
	return optionalProfile.get();
    }

    @Override
    @Transactional
    public ProfileDTO setLocation(LocationDTO locationDTO) {
	Profile profile = getProfileFromToken(locationDTO.getToken());
	ProfileDTO profileDTO = new ProfileDTO();
	profile.setLatitude(locationDTO.getLatitude());
	profile.setLongitude(locationDTO.getLongitude());
	profileDTO = toProfileDTO(profile);
	profileDTO.setToken(locationDTO.getToken());
	return profileDTO;
    }

    public ProfileDTO getProfile(String token) {
	ProfileDTO returnedProfileDTO = new ProfileDTO();
	returnedProfileDTO = toProfileDTO(getProfileFromToken(token));
	returnedProfileDTO.setToken(token);
	return returnedProfileDTO;
    }

    @Override
    public Profile getProfileFromToken(String userToken) {
	try {
		String token2 = userToken.replace("{\"userToken\":", "");
		String token3 = token2.replace("\"", "");
		String token4 = token3.replace("}", "");
		JwtInfo tokenInfo = jwtGenerator.getInfo(token4);
		Optional<Profile> profile = profileDAO.findById(tokenInfo.getUserId());
		return profile.get();  
	}catch(Exception e) {
	    throw new NoSuchElementException(); 
	}

    }

}
