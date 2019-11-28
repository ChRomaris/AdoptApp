package com.tfg.backend.Dtos;

import java.util.List;

import com.tfg.backend.Entities.AdoptionAnimal.AdoptionState;
import com.tfg.backend.Entities.Animal.Color;
import com.tfg.backend.Entities.Animal.AnimalGenre;
import com.tfg.backend.Entities.Animal.Size;
import com.tfg.backend.Entities.AnimalType;
import com.tfg.backend.Entities.Breed;

public class EnumsDTO {
    public List<AnimalType> animalTypes;
    public List<Breed> breeds;
    public List<AnimalGenre> genres;
    public List<Color> colors;
    public List<Size> sizes;
    public List<AdoptionState> adoptionStates;
    
    
    public EnumsDTO() {
	super();
    }
    
    
    
    public List<AnimalType> getAnimalTypes() {
        return animalTypes;
    }



    public void setAnimalTypes(List<AnimalType> animalTypes) {
        this.animalTypes = animalTypes;
    }



    public List<Breed> getBreeds() {
        return breeds;
    }
    public void setBreeds(List<Breed> breeds) {
        this.breeds = breeds;
    }
    public List<AnimalGenre> getGenres() {
        return genres;
    }
    public void setGenres(List<AnimalGenre> genres) {
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

    public List<AdoptionState> getAdoptionStates() {
        return adoptionStates;
    }

    public void setAdoptionStates(List<AdoptionState> adoptionStates) {
        this.adoptionStates = adoptionStates;
    }    
    
}
