package com.tfg.backend.Dtos;

import java.util.List;

public class ShelterListDTO {

    private List<ShelterDTO> shelters;

    public ShelterListDTO() {
	super();
    }

    public List<ShelterDTO> getShelters() {
        return shelters;
    }

    public void setShelters(List<ShelterDTO> shelters) {
        this.shelters = shelters;
    }
    
    
}
