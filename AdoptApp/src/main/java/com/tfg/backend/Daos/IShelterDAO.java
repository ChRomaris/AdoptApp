package com.tfg.backend.Daos;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.tfg.backend.Entities.RegisteredUser;
import com.tfg.backend.Entities.Shelter;
import com.tfg.backend.Entities.User;

public interface IShelterDAO extends PagingAndSortingRepository<Shelter, Long> {
	public Shelter findByAdmin (RegisteredUser user);
	public Shelter findByName (String name);
}
