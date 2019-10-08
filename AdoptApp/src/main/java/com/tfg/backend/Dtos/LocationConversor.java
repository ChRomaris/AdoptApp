package com.tfg.backend.Dtos;

import com.tfg.backend.Entities.Location;

public class LocationConversor {

    public LocationConversor() {

    }

    public final static Location toLocation (LocationDTO locationDTO) {
	Location location = new Location ();
	location.setComment(locationDTO.getComment());
	location.setDateTime(locationDTO.getDateTime());
	location.setLatitude(locationDTO.getLatitude());
	location.setLongitude(locationDTO.getLongitude());

	return location;
    }
}