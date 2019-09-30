package com.tfg.backend.Dtos;

import java.util.Calendar;

import com.tfg.backend.Entities.LostAnimal;
import com.tfg.backend.Entities.User;

public class LostAnimalInfoDTO {
    
    	private Float latitud;
    	private Float longitud;
    	private LostAnimal.AdoptionState state;
    	private Calendar dateTime;
    	private String comment;
    	private String userName;
    	private User user;
    	
	public LostAnimalInfoDTO() {	
	    super();
	}
	
	
	public String getUserName() {
	    return userName;
	}


	public void setUserName(String userName) {
	    this.userName = userName;
	}


	public User getUser() {
	    return user;
	}


	public void setUser(User user) {
	    this.user = user;
	}


	public Float getLatitud() {
	    return latitud;
	}
	public void setLatitud(Float latitud) {
	    this.latitud = latitud;
	}
	public Float getLongitud() {
	    return longitud;
	}
	public void setLongitud(Float longitud) {
	    this.longitud = longitud;
	}
	public LostAnimal.AdoptionState getState() {
	    return state;
	}
	public void setState(LostAnimal.AdoptionState state) {
	    this.state = state;
	}
	public Calendar getDateTime() {
	    return dateTime;
	}
	public void setDateTime(Calendar dateTime) {
	    this.dateTime = dateTime;
	}
	public String getComment() {
	    return comment;
	}
	public void setComment(String comment) {
	    this.comment = comment;
	}	
}
