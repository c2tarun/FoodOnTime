package com.fot.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import com.fot.model.Order;

public class OrderDAO extends BaseDAO{
	public static void saveOrder(Order order){
		Session session = getSession();
		session.beginTransaction();
		session.save(order);
		session.getTransaction().commit();
		session.close();
	}
}
