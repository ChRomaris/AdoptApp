package com.tfg.backend.Dtos;

public class DeleteAnimalDTO {
	
	private String userToken;
	private Long animalId;
	
	
	public DeleteAnimalDTO() {
		super();
	}
	
	public String getUserToken() {
		return userToken;
	}
	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}
	public Long getAnimalId() {
		return animalId;
	}
	public void setAnimalId(Long animalId) {
		this.animalId = animalId;
	}
	
	

}
