package com.tfg.backend.Dtos;

import java.util.Calendar;
import java.util.List;

import com.tfg.backend.Entities.Animal.Breed;
import com.tfg.backend.Entities.LostAnimal;
import com.tfg.backend.Entities.LostAnimal.LostState;
import com.tfg.backend.Entities.User;

public class LostAnimalInfoDTO {
    	private Long id;
    	private Float latitude;
    	private Float longitude;
    	private LostState state;
    	private Calendar dateTime;
    	private String comment;
    	private String userName;
    	private User user;
    	private String name;
    	private Breed breed;
    	private List<ImageDTO> images;
    	private String image;
    	
    	
    
    	
	public LostAnimalInfoDTO() {	
	    super();
	}
	
	
	
	
	
	public List<ImageDTO> getImages() {
	    return images;
	}





	public void setImages(List<ImageDTO> images) {
	    this.images = images;
	}





	public String getImage() {
	    return image;
	}





	public void setImage(String image) {
	    this.image = image;
	}





	public Long getId() {
	    return id;
	}



	public void setId(Long id) {
	    this.id = id;
	}




	public String getName() {
	    return name;
	}




	public void setName(String name) {
	    this.name = name;
	}




	public Breed getBreed() {
	    return breed;
	}




	public void setBreed(Breed breed) {
	    this.breed = breed;
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


	public Float getLatitude() {
	    return latitude;
	}
	public void setLatitude(Float latitud) {
	    this.latitude = latitud;
	}
	public Float getLongitude() {
	    return longitude;
	}
	public void setLongitude(Float longitud) {
	    this.longitude = longitud;
	}
	public LostState getState() {
	    return state;
	}
	public void setState(LostState state) {
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
