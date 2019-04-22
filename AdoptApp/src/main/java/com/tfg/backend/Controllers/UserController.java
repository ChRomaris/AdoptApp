package com.tfg.backend.Controllers;

import static com.tfg.backend.Dtos.UserConversor.toUser;
import static com.tfg.backend.Dtos.UserConversor.toUserDTO;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tfg.backend.Dtos.UserDTO;
import com.tfg.backend.Entities.User;
import com.tfg.backend.Services.IUserService;
import com.tfg.backend.Services.UserService;

@RestController
@RequestMapping("/user/")
public class UserController {
	@Autowired
	UserService userService;
	
	@PostMapping("/signUp")
	public ResponseEntity<UserDTO> signUp(@RequestBody UserDTO userDTO){
		User user = toUser(userDTO);
		
		userService.registerUser(user);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(user.getId()).toUri();
		
		return ResponseEntity.created(location).body(toUserDTO(user));
	}
	

}
