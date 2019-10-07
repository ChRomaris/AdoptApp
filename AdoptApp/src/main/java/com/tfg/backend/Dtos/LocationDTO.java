package com.tfg.backend.Dtos;

public class LocationDTO {
	
	private Float latitude;
	private Float longitude;
	private String token;
	
	public LocationDTO() {
		super();
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
