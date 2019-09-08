package com.tfg.backend.Dtos;

import com.tfg.backend.Entities.Profile;
import com.tfg.backend.Entities.RoleType;
import com.tfg.backend.Entities.User;

public class UserConversor {

    private UserConversor() {
    }

    public final static User toUser(UserDTO userDTO) {
	User user = new User();
	user.setAddress(userDTO.getAddress());
	user.setEmail(userDTO.getEmail());
	user.setLastname1(userDTO.getLastname());
	user.setLastname2(userDTO.getLastname2());
	user.setAddress(userDTO.getAddress());
	user.setName(userDTO.getName());
	user.setGenre(userDTO.getGenre());
	user.setRole(RoleType.USER);

	return user;

    }

    public final static UserDTO toUserDTO(User user) {

	UserDTO userDTO = new UserDTO();
	userDTO.setName(user.getName());
	userDTO.setLastname(user.getLastname1());
	userDTO.setLastname2(user.getLastname2());
	userDTO.setAddress(user.getAddress());
	userDTO.setEmail(user.getEmail());
	userDTO.setAddress(user.getAddress());
	userDTO.setGenre(user.getGenre());

	return userDTO;
    }

}
