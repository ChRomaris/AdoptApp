package com.tfg.backend.Dtos;

import java.util.List;

import com.tfg.backend.Entities.Location;

public class ReturnedLocationsDTO {

  private List<Location> locations;

public ReturnedLocationsDTO() {
    super();
}

public List<Location> getLocations() {
    return locations;
}

public void setLocations(List<Location> locations) {
    this.locations = locations;
}




}