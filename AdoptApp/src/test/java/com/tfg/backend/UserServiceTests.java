//package com.tfg.backend;
//
//import static org.junit.Assert.assertEquals;
//
//import javax.management.InstanceNotFoundException;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.tfg.backend.Daos.IUserDao;
//import com.tfg.backend.Entities.Profile;
//import com.tfg.backend.Exceptions.DuplicatedUserException;
//import com.tfg.backend.Exceptions.IncorrectLoginException;
//import com.tfg.backend.Services.ProfileService;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class UserServiceTests {
//	
//	@Autowired
//	ProfileService userService;
//	@Autowired
//	IUserDao userDao;
//	
//	@Test
//	public void registerUser () throws InstanceNotFoundException, DuplicatedUserException {
//			Profile usuario = new Profile();
//			usuario.setUserName("usernameUsuario");
//			userService.registerUpdateUser(usuario);
//			Profile usuarioEncontrado = userDao.findById(usuario.getRegisteredUserId()).get();
//			assertEquals(usuarioEncontrado.getUserName(), "usernameUsuario");
//	}
//	
//	@Test 
//	public void login() throws IncorrectLoginException, DuplicatedUserException {
//		Profile usuario = new Profile();
//		usuario.setUserName("username1");
//		usuario.setPassword("password1");
//		userService.registerUpdateUser(usuario);
//		Profile user = userService.login("username1", "password1");
//		
//		assertEquals(user, usuario);
//		
//		
//	}
//
//}
