package com.fot.dao.test;


import org.junit.Assert;
import org.junit.Test;

import com.fot.dao.UserDAO;
import com.fot.model.User;

public class UserDAOTest {
	
	@Test
	public void testSaveUser() {
		User user = new User("testUser","password","test","test","test@gmail.com");
		UserDAO.saveUser(user);
		Assert.assertTrue(true);
	}
	
	@Test
	public void testGetUserByUsername() {
		User user = UserDAO.getUserByUsername("testUser");
		Assert.assertNotNull(user);
	}

}
