package com.tfg.backend.Entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@SequenceGenerator(name="BREED_SEQ", sequenceName="breed_sequence")
public class Breed {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="BREED_SEQ")
    private Long breedId;
    
    @Column
    private String name;
    
   
    @ManyToOne
    @JoinColumn(name="animalTypeId", referencedColumnName = "animalTypeId")
    private AnimalType animalType;
    
    @JsonIgnore
    @OneToMany(mappedBy = "breed", cascade = CascadeType.ALL)
    private List<Animal> animals;
    
    @JsonIgnore
    @OneToMany (mappedBy = "breed", cascade = CascadeType.ALL)
    private List<Preferences> preferences;


    public List<Preferences> getPreferences() {
        return preferences;
    }


    public void setPreferences(List<Preferences> preferences) {
        this.preferences = preferences;
    }


    public Breed() {
	super();
    }


    public Long getBreedId() {
        return breedId;
    }


    public void setBreedId(Long breedId) {
        this.breedId = breedId;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public AnimalType getAnimalType() {
        return animalType;
    }


    public void setAnimalType(AnimalType animalType) {
        this.animalType = animalType;
    }


    public List<Animal> getAnimals() {
        return animals;
    }


    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }
    
    

}
