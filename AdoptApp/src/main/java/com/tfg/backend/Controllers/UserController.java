package com.tfg.backend.Controllers;

import java.util.Locale;
import java.util.NoSuchElementException;

import javax.management.InstanceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tfg.backend.Dtos.AnimalDTO;
import com.tfg.backend.Dtos.DeleteAnimalDTO;
import com.tfg.backend.Dtos.ErrorsDTO;
import com.tfg.backend.Dtos.LostAnimalPageDTO;
import com.tfg.backend.Dtos.UserPreferencesDTO;
import com.tfg.backend.Exceptions.ForbiddenException;
import com.tfg.backend.Services.IUserService;

@RestController
@RequestMapping("/user/")
public class UserController {
    
    private final static String BAD_REQUEST_EXCEPTION_CODE = "project.exceptions.BadRequestException";
    
    @Autowired
    IUserService userService;
    
    @Autowired
    private MessageSource messageSource;
    
    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorsDTO handleNoSuchElementException(NoSuchElementException exception, Locale locale) {
	String errorMessage = messageSource.getMessage(BAD_REQUEST_EXCEPTION_CODE, null, BAD_REQUEST_EXCEPTION_CODE,
		locale);
	return new ErrorsDTO(errorMessage);
    }

    @PostMapping("/addLostAnimal")
    public AnimalDTO addLostAnimal (@RequestBody AnimalDTO animalDTO) {
	return userService.addLostAnimal(animalDTO);
    
    }
    
    @GetMapping("/getAnimals")
    public LostAnimalPageDTO getLostAnimals (@RequestParam String userToken, @RequestParam int page) {
	return userService.getUserLostAnimals(userToken, page);
    }
    
    @PostMapping("deleteLost")
    public LostAnimalPageDTO deleteLostAnimal (@RequestBody DeleteAnimalDTO deleteAnimalDTO) throws InstanceNotFoundException, ForbiddenException {
	return userService.deleteLostAnimal(deleteAnimalDTO);
    }
    
    @GetMapping("/preferences")
    public UserPreferencesDTO getPreferences (@RequestParam String userToken) {
	return userService.getPreferences(userToken);
    }
    
    
    @PostMapping("/preferences")
    public UserPreferencesDTO editPreferences (@RequestBody UserPreferencesDTO userPreferencesDTO) throws InstanceNotFoundException, ForbiddenException {
	return userService.editPreferences(userPreferencesDTO);
    }
    
    
}
