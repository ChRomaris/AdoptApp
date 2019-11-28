package com.tfg.backend.Daos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.tfg.backend.Entities.Animal;
import com.tfg.backend.Entities.AnimalType;
import com.tfg.backend.Entities.Breed;

public interface IBreedDAO extends PagingAndSortingRepository<Breed, Long> {
    
    @Query("Select b from Breed b where b.animalType = :animalType")
    List<Breed> getBreeds(AnimalType animalType);
    
    @Query("Select b from Breed b")
    List<Breed> getAllBreeds();
    
    Breed findByName (String name);
    

}
