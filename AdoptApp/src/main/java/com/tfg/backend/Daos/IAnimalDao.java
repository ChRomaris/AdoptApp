package com.tfg.backend.Daos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.tfg.backend.Entities.AdoptionAnimal;
import com.tfg.backend.Entities.Animal;
import com.tfg.backend.Entities.Animal.Genre;

public interface IAnimalDao extends PagingAndSortingRepository<Animal, Long> {
    @Query("Select a From AdoptionAnimal a WHERE (:breed is null or a.breed = :breed) and "
    	+ "(:color is null or a.color = :color) and "
    	+ "(:genre is null or a.genre = :genre) and "
    	+ "(:size is null or a.size = :size) ")
    List<Animal> searchAnimalsByFilter (String breed, String color, Genre genre,   String size);
    
    @Query("Select distinct a.breed From AdoptionAnimal a ")
    List<String> getBreeds ();
    
    @Query("Select distinct a.color From AdoptionAnimal a ")
    List<String> getColors ();

}
