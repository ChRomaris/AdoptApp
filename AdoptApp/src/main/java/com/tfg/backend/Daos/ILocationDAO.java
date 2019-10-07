package com.tfg.backend.Daos;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.tfg.backend.Entities.Animal;
import com.tfg.backend.Entities.Location;


public interface ILocationDAO extends PagingAndSortingRepository<Location, Long> {

   List<Location> findByAnimal(Animal animal, Pageable page);
   List<Location> findByAnimal(Animal animal);
   int countByAnimal(Animal animal);
    
}
