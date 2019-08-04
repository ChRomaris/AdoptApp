package com.tfg.backend.Services;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tfg.backend.Common.JwtGenerator;
import com.tfg.backend.Common.JwtInfo;
import com.tfg.backend.Daos.IUserDao;
import com.tfg.backend.Dtos.AuthenticatedUserDTO;
import com.tfg.backend.Dtos.LocationDTO;
import com.tfg.backend.Entities.RegisteredUser;
import com.tfg.backend.Entities.User;
import com.tfg.backend.Exceptions.IncorrectLoginException;

@Service
public class UserService implements IUserService {

	@Autowired
	IUserDao userDao;
	
	@Autowired
	JwtGenerator jwtGenerator;

	@Override
	@Transactional
	public void registerUpdateUser(User user) {
		userDao.save(user);
	}

	public RegisteredUser findByUsername(String username) {
		Optional<User> user = userDao.findByUserName(username);

		return user.get();
	}

	@Override
	public RegisteredUser findById(Long id) {
		Optional<User> user = userDao.findById(id);

		return user.get();
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
	
	@Override
	@Transactional(readOnly = true)
	public User setLocation(LocationDTO locationDTO) {
		User user = getUserFromToken(locationDTO.getUserToken());
		
		if (user!=null) {
			user.setLatitude(locationDTO.getLatitude());
			user.setLongitude(locationDTO.getLongitude());
			user = userDao.save(user);
		}
		
		return user;
	}
	
	
	
	public User getUserFromToken (String userToken) {
		String token2 = userToken.replace("{\"userToken\":","");
		String token3 = token2.replace("\"","");
		String token4 = token3.replace("}","");
		JwtInfo tokenInfo = jwtGenerator.getInfo(token4);
		Optional<User> OptionalUser = userDao.findById(tokenInfo.getUserId());
		
		User user = null;
		try {
			user = OptionalUser.get();
			return user;
		}catch(NoSuchElementException e) {
			return user;
		
		}
	}
}
