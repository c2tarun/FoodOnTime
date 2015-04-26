package com.fot.dao.test;


import org.junit.Assert;
import org.junit.Test;

import com.fot.dao.UserDAO;
import com.fot.model.User;

public class UserDAOTest {
	
	@Test
	public void testSaveUser() {
		UserDAO.deleteUserByUsername("testUser1");
		User user = new User("testUser1","password","test","test","test@gmail.com","testNick");
		UserDAO.saveUser(user);
		user = UserDAO.getUserByUsername("testUser1");
		Assert.assertTrue(true);
		UserDAO.deleteUserByUsername("testUser1");
	}
	
	@Test
	public void testGetUserByUsername() {
		User user = UserDAO.getUserByUsername("testUser");
		Assert.assertNotNull(user);
	}
	
	@Test
	public void testUserCredentials() {
		User user = UserDAO.getUserByUsername("testUser");
		Assert.assertEquals("5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8", user.getPassword());
	}

	@Test
	public void testDeleteUser() {
		User user = new User("testReg","password","test","test","test@gmail.com","testNick");
		UserDAO.saveUser(user);
		Assert.assertTrue(UserDAO.deleteUserByUsername("testReg"));
	}
}


