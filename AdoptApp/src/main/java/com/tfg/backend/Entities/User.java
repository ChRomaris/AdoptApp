package com.tfg.backend.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "User")
public class User extends Profile {
	
	@Column
	private String name;
	@Column
	private String lastname1;
	@Column
	private String lastname2;
	@Column
	private String address;
	@Column 
	private String genre;
	@Column
	private String email;

	
	public User() {
	    setRole(RoleType.USER);
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


	public String getName() {
	    return name;
	}

	public void setName(String name) {
	    this.name = name;
	}

	public String getLastname1() {
	    return lastname1;
	}

	public void setLastname1(String lastname1) {
	    this.lastname1 = lastname1;
	}

	public String getLastname2() {
	    return lastname2;
	}

	public void setLastname2(String lastname2) {
	    this.lastname2 = lastname2;
	}

	public String getGenre() {
	    return genre;
	}

	public void setGenre(String genre) {
	    this.genre = genre;
	}


}