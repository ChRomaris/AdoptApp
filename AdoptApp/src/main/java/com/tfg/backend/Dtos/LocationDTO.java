package com.tfg.backend.Dtos;

import java.util.Calendar;

public class LocationDTO {
	
	private Float latitude;
	private Float longitude;
	private Calendar dateTime;
	private String comment;
	private String token;
	private Long animalId;
	private String userName;
	
	public LocationDTO() {
		super();
	}
	




	public String getUserName() {
	    return userName;
	}





	public void setUserName(String userName) {
	    this.userName = userName;
	}





	public Long getAnimalId() {
	    return animalId;
	}





	public void setAnimalId(Long animalId) {
	    this.animalId = animalId;
	}





	public String getComment() {
	    return comment;
	}



	public void setComment(String comment) {
	    this.comment = comment;
	}



	public Calendar getDateTime() {
	    return dateTime;
	}



	public void setDateTime(Calendar dateTime) {
	    this.dateTime = dateTime;
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
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	

}
