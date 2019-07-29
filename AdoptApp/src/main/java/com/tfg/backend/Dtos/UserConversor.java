package com.tfg.backend.Dtos;

import com.tfg.backend.Entities.User;

public class UserConversor {

	private UserConversor() {
	}

	public final static User toUser(UserDTO userDTO) {
		return new User(userDTO.getId(), userDTO.getUserName(), userDTO.getPassword(), userDTO.getName(), userDTO.getEmail(), userDTO.getLatitude(), userDTO.getLongitude());
	}

	public final static UserDTO toUserDTO(User user) {
		return new UserDTO(user.getId(), user.getUserName(), user.getPassword(), user.getName(), user.getPhoneNumber(),
				user.getEmail(), user.getAddress(), user.getLocation());
	}

	public final static AuthenticatedUserDTO toAutenticatedUserDTO(String serviceToken, User user) {
		return new AuthenticatedUserDTO(serviceToken, toUserDTO(user));
	}

}
