package com.tfg.backend.Dtos;

import java.util.List;

import com.tfg.backend.Entities.Animal.Genre;
import com.tfg.backend.Entities.Animal.Size;

public class AdoptionAnimalFilterValuesDTO {
    List <String> breeds;
    List <String> colors;
    List <Size> sizes;
    List <Genre> genres;
    
    public AdoptionAnimalFilterValuesDTO() {
	super();
    }
    
    public List<String> getBreeds() {
        return breeds;
    }
    public void setBreeds(List<String> breeds) {
        this.breeds = breeds;
    }
    public List<String> getColors() {
        return colors;
    }
    public void setColors(List<String> colors) {
        this.colors = colors;
    }
    public List<Size> getSizes() {
        return sizes;
    }
    public void setSizes(List<Size> sizes) {
        this.sizes = sizes;
    }
    public List<Genre> getGenres() {
        return genres;
    }
    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }
    
    
}
