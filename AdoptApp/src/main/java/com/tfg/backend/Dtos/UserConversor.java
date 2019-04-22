package com.tfg.backend.Dtos;

import com.tfg.backend.Entities.User;

public class UserConversor {
	
	private UserConversor() {}
	
	public final static User toUser(UserDTO userDTO) {
		
		return new User(userDTO.getUserName(), userDTO.getPassword(), userDTO.getName(), userDTO.getPhoneNumber(), userDTO.getEmail(), userDTO.getAddress(), userDTO.getLocation());
		
	}
	
	public final static UserDTO toUserDTO (User user) {
		return new UserDTO(user.getId(),user.getUserName(), user.getPassword(), user.getName(), user.getPhoneNumber(), user.getEmail(), user.getAddress(), user.getLocation());
	}

}
