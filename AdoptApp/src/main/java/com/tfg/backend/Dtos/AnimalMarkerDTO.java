package com.tfg.backend.Dtos;

import java.util.Calendar;

public class AnimalMarkerDTO {
    String name;
    Calendar birthDate;
    double distance;
    
    public AnimalMarkerDTO() {
	super();
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getDistance() {
        return distance;
    }
    public void setDistance(double distance) {
        this.distance = distance;
    }
    public Calendar getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(Calendar birthDate) {
        this.birthDate = birthDate;
    }
    
    
    
}
