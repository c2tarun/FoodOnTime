package com.fot.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;





import com.fot.model.Order;
import com.fot.model.Product;
import com.fot.model.User;

public class OrderDAO extends BaseDAO{
	public static void saveOrder(Order order){
		Session session = getSession();
		session.beginTransaction();
		session.save(order);
		session.getTransaction().commit();
		session.close();
	}
	
	public static int getOrderId(){
		Session session = getSession();
		session.beginTransaction();
		
		Query count = session.createQuery("Select COUNT(orderId) from Order");
		
		Query query = session.createQuery("Select MAX(orderId) from Order");
		
		long num = (long) count.uniqueResult();
		if(num==0){
			return 0;
		}
		
		else return (int) query.uniqueResult();

	}

	public static List<Order> getOrders(String user) {
		Session session = getSession();
		Query query = session.createQuery("from Order where user= :user"); 
		query.setString("user", user);
		List<Order> orders = query.list();
		
		return orders;
	}
}
