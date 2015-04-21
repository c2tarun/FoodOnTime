package com.fot.dao;

import org.hibernate.Query;
import org.hibernate.Session;

import com.fot.model.User;

public class UserDAO extends BaseDAO {
	
	public static void saveUser(User user) {
		Session session = getSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
	}
	
	public static void updateUser(User user) {
		Session session = getSession();
		session.beginTransaction();
		session.update(user);
		session.getTransaction().commit();
		session.close();
	}
	
	public static User getUserByUsername(String username) {
		Session session = getSession();
		session.beginTransaction();
		
		Query query = session.createQuery("from User where username = :username");
		query.setString("username", username);
		User user = (User) query.uniqueResult();
		return user;
	}
	
	public static boolean deleteUserByUsername(String username) {
		Session session = getSession();
		session.beginTransaction();
		
		Query query = session.createQuery("delete User where username = :username");
		query.setString("username", username);
		int result = query.executeUpdate();
		session.getTransaction().commit();
		session.close();
		return result > 0;
	}
}
