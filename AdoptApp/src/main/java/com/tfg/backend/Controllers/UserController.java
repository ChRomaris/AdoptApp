package com.tfg.backend.Controllers;

import static com.tfg.backend.Dtos.UserConversor.toAutenticatedUserDTO;
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

import com.tfg.backend.Common.JwtGenerator;
import com.tfg.backend.Common.JwtInfo;
import com.tfg.backend.Dtos.AuthenticatedUserDTO;
import com.tfg.backend.Dtos.UserDTO;
import com.tfg.backend.Entities.RegisteredUser.RoleType;
import com.tfg.backend.Entities.User;
import com.tfg.backend.Exceptions.IncorrectLoginException;
import com.tfg.backend.Services.UserService;

@RestController
@RequestMapping("/user/")
public class UserController {
	@Autowired
	UserService userService;

	@Autowired
	JwtGenerator tokenProvider;

	@Autowired
	private JwtGenerator jwtGenerator;

	@PostMapping("/registerUpdateUser")
	public AuthenticatedUserDTO  signUp(@RequestBody UserDTO userDTO) {

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

}
