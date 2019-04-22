package com.tfg.backend.Services;

import java.util.Optional;

import javax.management.InstanceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tfg.backend.Daos.IUserDao;
import com.tfg.backend.Entities.User;
import com.tfg.backend.Exceptions.IncorrectLoginException;

@Service
public class UserService implements IUserService {

	@Autowired
	IUserDao userDao;
	
	@Override
    @Transactional
	public void registerUser(User user) {
		userDao.save(user);
	}
	
	@Override
    @Transactional(readOnly = true)
	public User login(String username, String password) throws IncorrectLoginException {
		Optional<User> user = userDao.findByUserName(username);

		if (user.isPresent() && user.get().getPassword().equals(password)) {
			return user.get();
		} else {
			throw new IncorrectLoginException();
		}

	}

}
