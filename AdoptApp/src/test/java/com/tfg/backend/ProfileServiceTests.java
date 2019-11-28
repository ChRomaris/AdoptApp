//package com.tfg.backend;
//
//import static org.junit.Assert.assertEquals;
//
//import javax.management.InstanceNotFoundException;
//import javax.transaction.Transactional;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.tfg.backend.Dtos.LocationDTO;
//import com.tfg.backend.Dtos.ProfileDTO;
//import com.tfg.backend.Dtos.UserDTO;
//import com.tfg.backend.Entities.Profile;
//import com.tfg.backend.Entities.Profile.ProfileGenre;
//import com.tfg.backend.Entities.RoleType;
//import com.tfg.backend.Exceptions.IncorrectLoginException;
//import com.tfg.backend.Services.IProfileService;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@ActiveProfiles("test")
//@Transactional
//public class ProfileServiceTests {
//    
//    @Autowired
//    IProfileService profileService;
//
//    @Test
//    public void registerLoginProfileTest() throws IncorrectLoginException {
//	ProfileDTO profileDTO = new ProfileDTO();
//	profileDTO.setUsername("usuarioPrueba");
//	profileDTO.setPassword("passPrueba");
//	profileDTO.setRole(RoleType.USER);
//	UserDTO userDTO = new UserDTO();
//	userDTO.setName("usuario1");
//	userDTO.setLastname("lastname1");
//	userDTO.setLastname2("lastname2");
//	userDTO.setGenre(ProfileGenre.HOMBRE);
//	userDTO.setEmail("mail@hotmail.com");
//	userDTO.setAddress("calle fuente alamo");
//	profileDTO.setUserDTO(userDTO);
//	
//	profileService.registerProfile(profileDTO);
//	ProfileDTO profile = profileService.login("usuarioPrueba", "passPrueba");
//	
//	assertEquals(profile.getUsername(), profileDTO.getUsername());
//	
//    }
//    
//    
//    @Test
//    public void setLocationFindByIdTest() throws IncorrectLoginException {
//	ProfileDTO profileDTO = new ProfileDTO();
//	profileDTO.setUsername("usuarioPrueba");
//	profileDTO.setPassword("passPrueba");
//	profileDTO.setRole(RoleType.USER);
//	UserDTO userDTO = new UserDTO();
//	userDTO.setName("usuario1");
//	userDTO.setLastname("lastname1");
//	userDTO.setLastname2("lastname2");
//	userDTO.setGenre(ProfileGenre.HOMBRE);
//	userDTO.setEmail("mail@hotmail.com");
//	userDTO.setAddress("calle fuente alamo");
//	profileDTO.setUserDTO(userDTO);
//	
//	ProfileDTO registered = profileService.registerProfile(profileDTO);
//	LocationDTO locationDTO = new LocationDTO();
//	locationDTO.setLatitude(new Float(-42));
//	locationDTO.setLongitude(new Float(-43));
//	locationDTO.setToken(registered.getToken());
//	
//	profileService.setLocation(locationDTO);
//	
//	Profile found = profileService.findById(registered.getId());
//	
//	
//	assertEquals(found.getLatitude(), new Float(-42));
//	assertEquals(found.getLongitude(), new Float(-43));
//	
//	
//    }
//    
//    @Test
//    public void updateProfileGetFromTokenTest() throws InstanceNotFoundException, IncorrectLoginException {
//	ProfileDTO profileDTO = new ProfileDTO();
//	profileDTO.setUsername("usuarioPrueba");
//	profileDTO.setPassword("pass1");
//	profileDTO.setRole(RoleType.USER);
//	UserDTO userDTO = new UserDTO();
//	userDTO.setName("usuario1");
//	userDTO.setLastname("lastname1");
//	userDTO.setLastname2("lastname2");
//	userDTO.setGenre(ProfileGenre.HOMBRE);
//	userDTO.setEmail("mail@hotmail.com");
//	userDTO.setAddress("calle fuente alamo");
//	profileDTO.setUserDTO(userDTO);
//	
//	ProfileDTO registered = profileService.registerProfile(profileDTO);
//	
//	ProfileDTO updatedProfileDTO = new ProfileDTO();
//	updatedProfileDTO.setUsername("usuarioPrueba");
//	updatedProfileDTO.setPassword("pass2");
//	updatedProfileDTO.setRole(RoleType.USER);
//	updatedProfileDTO.setToken(registered.getToken());
//	
//	UserDTO updatedUserDTO = new UserDTO();
//	updatedUserDTO.setName("userPrueba");
//	updatedUserDTO.setLastname("lastname1");
//	updatedUserDTO.setLastname2("lastname2");
//	updatedUserDTO.setGenre(ProfileGenre.HOMBRE);
//	updatedUserDTO.setEmail("mail@hotmail.com");
//	updatedUserDTO.setAddress("calle fuente alamo");
//	updatedProfileDTO.setUserDTO(updatedUserDTO);
//	
//	ProfileDTO up = profileService.updateProfile(updatedProfileDTO);
//	
//	Profile updated = profileService.getProfileFromToken(up.getToken());
//
//	
//	assertEquals(registered.getPassword(), "pass1");
//	assertEquals(updated.getPassword(), "pass2");
//	
//	
//	
//	
//    }
//    
//
//    
//    
//    
//}
