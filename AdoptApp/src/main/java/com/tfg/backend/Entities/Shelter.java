package com.tfg.backend.Entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Shelter")
public class Shelter  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long shelter_id;
	@Column
	private String type;
	@Column
	private String name;
	@Column
	private Long phoneNumber;
	@Column
	private String email;
	@Column
	private String address;
	@Column
	private String location;
	
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public long getShelter_id() {
		return shelter_id;
	}

	public void setShelter_id(long shelter_id) {
		this.shelter_id = shelter_id;
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

	public Shelter( String type, String name, Long phoneNumber, String email, String address,
			String location) {
		super();
		this.type = type;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
		this.location = location;
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

	public Shelter() {
		
	}
	

}