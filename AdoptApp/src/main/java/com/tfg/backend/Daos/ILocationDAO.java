package com.tfg.backend.Daos;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.tfg.backend.Entities.LostAnimal;

public interface ILocationDAO extends PagingAndSortingRepository<LostAnimal, Long> {

}
