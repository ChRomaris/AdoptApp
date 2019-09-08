package com.tfg.backend.Dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthenticatedUserDTO {

	private String serviceToken;
	private UserDTO userDto;
	private long id;
	private String shelterName;


	public AuthenticatedUserDTO() {
	}
	
	public String getShelterName() {
		return shelterName;
	}

	public void setShelterName(String shelterName) {
		this.shelterName = shelterName;
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setUserDto(UserDTO userDto) {
		this.userDto = userDto;
	}

}
