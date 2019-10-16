package com.tfg.backend.Dtos;

import javax.persistence.Column;

public class ShelterDTO {
    	private Long id;
	private String type;
	private String name;
	private Long phoneNumber;
	private String email;
	private String address;
	private String description;
	private Float latitude;
	private Float longitude;
	private Double distance;
	
	
	public ShelterDTO() {
		super();
	}
	
	
	
	
	



	public Double getDistance() {
	    return distance;
	}











	public void setDistance(Double distance) {
	    this.distance = distance;
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











	public Long getId() {
	    return id;
	}



	public void setId(Long id) {
	    this.id = id;
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

	
	
}
