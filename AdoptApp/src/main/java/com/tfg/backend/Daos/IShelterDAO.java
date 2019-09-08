package com.tfg.backend.Daos;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.tfg.backend.Entities.User;
import com.tfg.backend.Entities.Shelter;
import com.tfg.backend.Entities.Profile;

public interface IShelterDAO extends PagingAndSortingRepository<Shelter, Long> {
	public Shelter findByName (String name);
}
