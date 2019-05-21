package com.tfg.backend.Dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthenticatedUserDTO {

	private String serviceToken;
	private UserDTO userDto;

	public AuthenticatedUserDTO() {
	}

	public AuthenticatedUserDTO(String serviceToken, UserDTO userDto) {

		this.serviceToken = serviceToken;
		this.userDto = userDto;

	}

	public String getServiceToken() {
		return serviceToken;
	}

	public void setServiceToken(String serviceToken) {
		this.serviceToken = serviceToken;
	}

	@JsonProperty("user")
	public UserDTO getUserDto() {
		return userDto;
	}

	public void setUserDto(UserDTO userDto) {
		this.userDto = userDto;
	}

}
