package com.tfg.backend.Controllers;

import static com.tfg.backend.Dtos.UserConversor.toAutenticatedUserDTO;
import static com.tfg.backend.Dtos.UserConversor.toUser;
import static com.tfg.backend.Dtos.UserConversor.toUserDTO;

import java.net.URI;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
import com.tfg.backend.Dtos.UserDTO;
import com.tfg.backend.Entities.RegisteredUser.RoleType;
import com.tfg.backend.Entities.User;
import com.tfg.backend.Exceptions.DuplicatedUserException;
import com.tfg.backend.Exceptions.IncorrectLoginException;
import com.tfg.backend.Services.UserService;

@RestController
@RequestMapping("/user/")
public class UserController {

    private final static String DUPLICATED_USER_EXCEPTION_CODE = "project.exceptions.DuplicatedUserException";
    private final static String INCORRECT_LOGIN_EXCEPTION_CODE = "project.exceptions.IncorrectLoginException";

    @Autowired
    UserService userService;

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
    
    

    @PostMapping("/registerUpdateUser")
    public AuthenticatedUserDTO signUp(@RequestBody UserDTO userDTO) throws DuplicatedUserException {
	User user = toUser(userDTO);
	user.setRole(RoleType.USER);
	userService.registerUpdateUser(user);
	URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId())
		.toUri();
	return toAutenticatedUserDTO(generateServiceToken(user), user);
    }

    @PostMapping("/login")
    public AuthenticatedUserDTO login(@RequestBody UserDTO userDTO) throws IncorrectLoginException {
	User user = toUser(userDTO);
	User usuarioAutenticado = userService.login(user.getUserName(), user.getPassword());
	return toAutenticatedUserDTO(generateServiceToken(usuarioAutenticado), usuarioAutenticado);
    }

    private String generateServiceToken(User user) {
	JwtInfo jwtInfo = new JwtInfo(user.getId(), user.getUserName(), user.getRole().toString());
	return jwtGenerator.generate(jwtInfo);
    }

    @PostMapping("/setLocation")
    public UserDTO setLocation(@RequestBody LocationDTO locationDTO) {
	return toUserDTO(userService.setLocation(locationDTO));
    }

}
