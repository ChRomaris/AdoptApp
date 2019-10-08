package com.tfg.backend.Dtos;

public class LocationPageRequestDTO {

    String token;
    Long animalId;
    int page;


    public LocationPageRequestDTO() {
	super();
    }


    public String getToken() {
        return token;
    }


    public void setToken(String token) {
        this.token = token;
    }


    public Long getAnimalId() {
        return animalId;
    }


    public void setAnimalId(Long animalId) {
        this.animalId = animalId;
    }


    public int getPage() {
        return page;
    }


    public void setPage(int page) {
        this.page = page;
    }
}