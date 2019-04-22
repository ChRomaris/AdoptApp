package com.tfg.backend.Entities;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="User")
public class User extends RegisteredUser {
	public enum RoleType {USER};
	
@Column
 private String lastName;
@Column
 private String lastName2;

 public User() {}

public User(String userName, String password, String name, Long phoneNumber, String email, String address,
		String location) {
	
	super(userName, password, name, phoneNumber, email, address, location);

	
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String getLastName2() {
	return lastName2;
}

public void setLastName2(String lastName2) {
	this.lastName2 = lastName2;
}

 
 
	
}