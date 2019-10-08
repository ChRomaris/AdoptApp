package com.tfg.backend.Dtos;

import java.util.List;

import com.tfg.backend.Entities.Location;

public class ReturnedLocationsPageDTO {

    private List<Location> locations;
    private int pageNumbers;


    public ReturnedLocationsPageDTO() {
	super();
    }

    public List<Location> getLocations() {
        return locations;
    }
    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public int getPageNumbers() {
        return pageNumbers;
    }

    public void setPageNumbers(int pageNumbers) {
        this.pageNumbers = pageNumbers;
    }





}