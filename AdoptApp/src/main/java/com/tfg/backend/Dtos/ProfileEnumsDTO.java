package com.tfg.backend.Dtos;

import java.util.List;

import com.tfg.backend.Entities.Profile.Genre;
import com.tfg.backend.Entities.Profile.Type;

public class ProfileEnumsDTO {
    private List<Type> types;
    private List<Genre> genres;
    
    public ProfileEnumsDTO() {
	super();
    }

    public List<Type> getTypes() {
        return types;
    }

    public void setTypes(List<Type> types) {
        this.types = types;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }
   
}
