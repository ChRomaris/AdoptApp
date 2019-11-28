package com.tfg.backend.Daos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.tfg.backend.Entities.AdoptionAnimal;
import com.tfg.backend.Entities.Animal;
import com.tfg.backend.Entities.Breed;

public interface IAnimalDao extends PagingAndSortingRepository<Animal, Long> {
    @Query("Select a From AdoptionAnimal a WHERE (:breed is not null and a.breed = :breed) or (:size is not null and a.size = :size)")
    List<Animal> searchAnimalsByFilter (Breed breed, String size);
   

}
