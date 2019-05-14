package com.tfg.backend.Daos;

import java.util.Optional;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.tfg.backend.Entities.Animal;

public interface IAnimalDao extends PagingAndSortingRepository<Animal, Long> {
	


}
