package com.tfg.backend.Dtos;

public class SearchShelterAnimalsDTO {

	private String token;
	private int page;
	
	public int getPage() {
	    return page;
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
