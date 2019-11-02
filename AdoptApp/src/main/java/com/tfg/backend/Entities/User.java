package com.tfg.backend.Entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
	private Genre genre;
	@Column
	private String email;
	

	@JsonIgnore
	@OneToMany(mappedBy="owner", cascade = CascadeType.ALL)
	private List<LostAnimal> lostAnimals;


	
	public User() {
	    setRole(RoleType.USER);
	}
	

	public List<LostAnimal> getLostAnimals() {
	    return lostAnimals;
	}

	public void setLostAnimals(List<LostAnimal> lostAnimals) {
	    this.lostAnimals = lostAnimals;
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


	public Genre getGenre() {
	    return genre;
	}


	public void setGenre(Genre genre) {
	    this.genre = genre;
	}




}