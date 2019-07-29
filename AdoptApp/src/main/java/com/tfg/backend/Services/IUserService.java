package com.tfg.backend.Services;

import com.tfg.backend.Entities.RegisteredUser;
import com.tfg.backend.Entities.User;
import com.tfg.backend.Exceptions.IncorrectLoginException;

public interface IUserService {


	User login(String username, String password) throws IncorrectLoginException;

	RegisteredUser findById(Long userId);

	void registerUpdateUser(User user);

}
