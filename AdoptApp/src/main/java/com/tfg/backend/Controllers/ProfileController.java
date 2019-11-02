package com.tfg.backend.Controllers;

import static com.tfg.backend.Dtos.UserConversor.toUser;
import static com.tfg.backend.Dtos.UserConversor.toUserDTO;

import java.net.URI;
import java.util.Locale;

import javax.management.InstanceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tfg.backend.Common.JwtGenerator;
import com.tfg.backend.Common.JwtInfo;
import com.tfg.backend.Dtos.AuthenticatedUserDTO;
import com.tfg.backend.Dtos.ErrorsDTO;
import com.tfg.backend.Dtos.LocationDTO;
import com.tfg.backend.Dtos.ProfileDTO;
import com.tfg.backend.Dtos.ProfileEnumsDTO;
import com.tfg.backend.Dtos.UserDTO;
import com.tfg.backend.Entities.Profile;
import com.tfg.backend.Entities.RoleType;
import com.tfg.backend.Exceptions.DuplicatedUserException;
import com.tfg.backend.Exceptions.IncorrectLoginException;
import com.tfg.backend.Services.ProfileService;

@RestController
@RequestMapping("/profile/")
public class ProfileController {

    private final static String DUPLICATED_USER_EXCEPTION_CODE = "project.exceptions.DuplicatedUserException";
    private final static String INCORRECT_LOGIN_EXCEPTION_CODE = "project.exceptions.IncorrectLoginException";

    @Autowired
    ProfileService profileService;

    @Autowired
    JwtGenerator tokenProvider;

    @Autowired
    private JwtGenerator jwtGenerator;

    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(DuplicatedUserException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorsDTO handleDuplicatedUserException(DuplicatedUserException exception, Locale locale) {
	String errorMessage = messageSource.getMessage(DUPLICATED_USER_EXCEPTION_CODE, null,
		DUPLICATED_USER_EXCEPTION_CODE, locale);
	return new ErrorsDTO(errorMessage);
    }
    
    @ExceptionHandler(IncorrectLoginException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorsDTO handleIncorrectLoginException(IncorrectLoginException exception, Locale locale) {
	String errorMessage = messageSource.getMessage(INCORRECT_LOGIN_EXCEPTION_CODE, null,
		INCORRECT_LOGIN_EXCEPTION_CODE, locale);
	return new ErrorsDTO(errorMessage);
    }
    
    

    
    @PostMapping("/register")
    public ProfileDTO signUp(@RequestBody ProfileDTO profileDTO)  {
	return profileService.registerProfile(profileDTO);	
    }
    
    @PostMapping("/login")
    public ProfileDTO login(@RequestBody ProfileDTO profileDTO) throws IncorrectLoginException  {
	ProfileDTO perfilAutenticado = profileService.login(profileDTO.getUsername(), profileDTO.getPassword());
	String token = generateServiceToken(perfilAutenticado);
	perfilAutenticado.setToken(token);
	return perfilAutenticado;
    }
    
    
    @PostMapping("/update")
    public ProfileDTO update(@RequestBody ProfileDTO profileDTO) throws InstanceNotFoundException{
	return profileService.updateProfile(profileDTO);
    }
   

    @PostMapping("/setLocation")
    public ProfileDTO setLocation(@RequestBody LocationDTO locationDTO) {
	return profileService.setLocation(locationDTO);
    }
    
    @PostMapping("/getInfo")
    public ProfileDTO getProfileInfo (@RequestBody ProfileDTO profileDTO) {
	return profileService.getProfile(profileDTO.getToken());
    }
    
    private String generateServiceToken(ProfileDTO profileDTO) {
	JwtInfo jwtInfo = null;
	if(profileDTO.getRole().equals(RoleType.USER)) {
	    jwtInfo = new JwtInfo(profileDTO.getId(), profileDTO.getUsername(), RoleType.USER);
	}else {
	    jwtInfo = new JwtInfo(profileDTO.getId(), profileDTO.getUsername(), RoleType.SHELTER);
	}
	
	return jwtGenerator.generate(jwtInfo);
    }
    
    @GetMapping("/enums")
    private ProfileEnumsDTO getProfileEnums() {
	return profileService.getProfileEnums();
    }

}

