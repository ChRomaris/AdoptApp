package com.tfg.backend.Daos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.tfg.backend.Entities.Animal;
import com.tfg.backend.Entities.AnimalType;

public interface IAnimalTypeDAO extends PagingAndSortingRepository<AnimalType, Long> {
    
    public AnimalType findByName(String name);
    @Query("Select t From AnimalType t")
    public List<AnimalType> getTypes();

}
