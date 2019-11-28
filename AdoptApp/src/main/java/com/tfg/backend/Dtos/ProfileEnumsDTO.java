package com.tfg.backend.Dtos;

import java.util.List;

import com.tfg.backend.Entities.Profile.ProfileGenre;
import com.tfg.backend.Entities.Profile.Type;

public class ProfileEnumsDTO {
    private List<Type> types;
    private List<ProfileGenre> genres;
    
    public ProfileEnumsDTO() {
	super();
    }

    public List<Type> getTypes() {
        return types;
    }

    public void setTypes(List<Type> types) {
        this.types = types;
    }

    public List<ProfileGenre> getGenres() {
        return genres;
    }

    public void setGenres(List<ProfileGenre> genres) {
        this.genres = genres;
    }
   
}
