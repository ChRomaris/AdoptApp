package com.tfg.backend.Entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Shelter")
public class Shelter extends Profile {

    @Column
    private String type;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private Long phoneNumber;
    @Column 
    private String description;
    @Column
    private String address;
    
    @JsonManagedReference
    @OneToMany(mappedBy = "shelter", cascade = CascadeType.ALL)
    private List<AdoptionAnimal> animals;

    public Shelter() {
	setRole(RoleType.SHELTER);
    }

    public String getType() {
	return type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<AdoptionAnimal> getAnimals() {
	return animals;
    }

    public void setAnimals(List<AdoptionAnimal> animals) {
	this.animals = animals;
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


}