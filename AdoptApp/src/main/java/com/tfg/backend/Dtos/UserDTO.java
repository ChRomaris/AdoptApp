	package com.tfg.backend.Dtos;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.tfg.backend.Entities.Profile.ProfileGenre;

public class UserDTO  {

	private String name;
	private String lastname;
	private String lastname2;
	private String email;
	private String address;
	private ProfileGenre genre;
	
	public UserDTO() {
		super();
	}

	

	public ProfileGenre getGenre() {
	    return genre;
	}



	public void setGenre(ProfileGenre genre) {
	    this.genre = genre;
	}



	public String getLastname() {
	    return lastname;
	}

	public void setLastname(String lastname) {
	    this.lastname = lastname;
	}

	public String getLastname2() {
	    return lastname2;
	}

	public void setLastname2(String lastname2) {
	    this.lastname2 = lastname2;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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

	
	
	

}
