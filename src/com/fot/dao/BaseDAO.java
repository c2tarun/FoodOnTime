package com.fot.dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

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
		String configFile = "";
		try {
			Context env = (Context) new InitialContext().lookup("java:comp/env");
			configFile = (String) env.lookup("dbconfig");
		} catch (NamingException e) {
			configFile = "hibernate_test.cfg.xml";
		}
		System.out.println("Got configFile ************ " + configFile);
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
