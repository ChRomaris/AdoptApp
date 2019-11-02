package com.tfg.backend.Dtos;

public class SearchShelterAnimalsDTO {

	private String token;
	private Long shelterId;
	private int page;
	
	public int getPage() {
	    return page;
	}

	
	public Long getShelterId() {
	    return shelterId;
	}


	public void setShelterId(Long shelterId) {
	    this.shelterId = shelterId;
	}


	public void setPage(int page) {
	    this.page = page;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	
}
