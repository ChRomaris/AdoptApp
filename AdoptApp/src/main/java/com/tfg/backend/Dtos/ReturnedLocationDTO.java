package com.tfg.backend.Dtos;

public class ReturnedLocationDTO {
    
    private Long locationId;
    private Float latitude;
    private Float longitude;
    
    public ReturnedLocationDTO() {
	super();
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
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
    
    
}
