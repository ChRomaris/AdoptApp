package com.tfg.backend.Dtos;

import java.util.List;

import com.tfg.backend.Entities.Animal.Breed;
import com.tfg.backend.Entities.Animal.Color;
import com.tfg.backend.Entities.Animal.Genre;
import com.tfg.backend.Entities.Animal.Size;

public class EnumsDTO {

    public List<Breed> breeds;
    public List<Genre> genres;
    public List<Color> colors;
    public List<Size> sizes;
    
    
    public EnumsDTO() {
	super();
    }
    
    public List<Breed> getBreeds() {
        return breeds;
    }
    public void setBreeds(List<Breed> breeds) {
        this.breeds = breeds;
    }
    public List<Genre> getGenres() {
        return genres;
    }
    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }
    public List<Color> getColors() {
        return colors;
    }
    public void setColors(List<Color> colors) {
        this.colors = colors;
    }
    public List<Size> getSizes() {
        return sizes;
    }
    public void setSizes(List<Size> sizes) {
        this.sizes = sizes;
    }
    
    
}
