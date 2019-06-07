package com.tfg.backend.Daos;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.tfg.backend.Entities.AdoptionAnimal;
import com.tfg.backend.Entities.Animal;

public interface IAdoptionAnimalDao extends PagingAndSortingRepository<AdoptionAnimal, Long> {

}
