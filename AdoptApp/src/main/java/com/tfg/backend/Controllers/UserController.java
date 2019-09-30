package com.tfg.backend.Controllers;

import java.util.Locale;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tfg.backend.Dtos.AnimalDTO;
import com.tfg.backend.Dtos.ErrorsDTO;
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
   
    
    
    
    
    
    
    
    
    
    
}
