package com.tfg.backend.Daos;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.tfg.backend.Entities.LostAnimal;

public interface ILostAnimalDAO extends PagingAndSortingRepository<LostAnimal, Long> {
    	
}
