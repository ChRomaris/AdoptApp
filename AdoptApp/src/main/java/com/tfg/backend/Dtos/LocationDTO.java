package com.tfg.backend.Dtos;

public class LocationDTO {
	
	private Float latitude;
	private Float longitude;
	private String userToken;
	
	public LocationDTO() {
		super();
	}

	public LocationDTO(Float latitude, Float longitude, String userToken) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
		this.userToken = userToken;
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
	public String getUserToken() {
		return userToken;
	}
	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}
	
	

}
