package com.tfg.backend.Daos;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.tfg.backend.Entities.Animal;
import com.tfg.backend.Entities.AnimalPicture;

public interface IAnimalPictureDao extends PagingAndSortingRepository<AnimalPicture, Long> {

}
