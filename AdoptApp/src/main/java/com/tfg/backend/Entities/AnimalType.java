package com.tfg.backend.Entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@SequenceGenerator(name="ANIMALTYPE_SEQ", sequenceName="animalType_sequence")
public class AnimalType {	
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="ANIMALTYPE_SEQ")
    private Long animalTypeId;
    
    @Column
    private String name;
    
    @JsonIgnore
    @OneToMany(mappedBy = "animalType", cascade = CascadeType.ALL)
    private List<Breed> breeds;
    
    
    @JsonIgnore
    @OneToMany(mappedBy = "animalType", cascade = CascadeType.ALL)
    private List<Animal> animals;
    
    

    public AnimalType() {
	super();
    }

    public Long getAnimalTypeId() {
        return animalTypeId;
    }

    public void setAnimalTypeId(Long animalTypeId) {
        this.animalTypeId = animalTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Breed> getBreeds() {
        return breeds;
    }

    public void setBreeds(List<Breed> breeds) {
        this.breeds = breeds;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }
    
    
    
    

}
