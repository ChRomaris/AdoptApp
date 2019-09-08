package com.tfg.backend.Daos;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.tfg.backend.Entities.User;
import com.tfg.backend.Entities.Profile;

public interface IUserDao extends PagingAndSortingRepository<User, Long> {
	
	public Optional<User> findByUsername (String username);

}
