package com.fot.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class BaseDAO {

	static Configuration configuration;
	static StandardServiceRegistry serviceRegistery;
	static SessionFactory sessionFactory;

	private static void buildSessionFactory() {
		configuration = new Configuration().configure();
		serviceRegistery = new StandardServiceRegistryBuilder().applySettings(
				configuration.getProperties()).build();
		sessionFactory = configuration.configure().buildSessionFactory(
				serviceRegistery);
	}

	public static Session getSession() {
		if (sessionFactory == null)
			buildSessionFactory();
		return sessionFactory.openSession();
	}

}
