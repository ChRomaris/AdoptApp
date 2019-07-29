package com.tfg.backend.Dtos;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class UserDTO {
	

	private long Id;
	private String userName;
	private String password;
	private String name;
	private Long phoneNumber;
	private String email;
	private String address;
	private String location;
	private Float latitude;
	private Float longitude;
	
	public UserDTO() {
		super();
	}

	public UserDTO(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	
	public UserDTO(long id, String userName, String password, String name, Long phoneNumber, String email,
			String address, String location) {
		super();
		this.Id = id;
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
		this.location = location;
	}
	
	public UserDTO(String userName, String password, String name, Long phoneNumber, String email,
			String address, String location) {
		super();
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
		this.location = location;
	}
	

	public UserDTO(String userName, String password, String name, Long phoneNumber, String email, String address,
			String location, Float latitude, Float longitude) {
		super();
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
		this.location = location;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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

	public Float getLatitude() {
		return latitude;
	}

	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}

	public Float getLongitude() {
		return longitude;
	}

	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}
	
	
	

}
