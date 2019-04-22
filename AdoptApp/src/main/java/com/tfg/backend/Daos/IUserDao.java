package com.tfg.backend.Daos;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.tfg.backend.Entities.RegisteredUser;
import com.tfg.backend.Entities.User;

public interface IUserDao  extends PagingAndSortingRepository<User, Long> {
	
	public Optional<User> findByUserName (String username);

}
