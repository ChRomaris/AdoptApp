package com.tfg.backend.Dtos;

import javax.persistence.Column;

public class ShelterDTO {
	
	private String type;
	private String name;
	private Long phoneNumber;
	private String email;
	private String address;
	private String location;
	private String userToken;
	
	public String getUserToken() {
		return userToken;
	}
	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public ShelterDTO(String type, String name, Long phoneNumber, String email, String address, String location) {
		super();
		this.type = type;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
		this.location = location;
	}
	public ShelterDTO() {
		super();
	}
	
	

	
	
}
