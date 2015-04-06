package com.fot.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.fot.model.Product;

public final class ProductDAO extends BaseDAO {

	public static List<Product> getAll() {
		
		Session session = getSession();
		Query query = session.createQuery("from Product"); 
		List<Product> products = query.list();
		return products;
	}

	public static Product getProductByCode(String productCode) {
		
		Session session = getSession();
		Query query = session.createQuery("from Product where productCode = :productCode");
		query.setString("productCode", productCode);
		return (Product) query.uniqueResult();
	}

	public static List<Product> getProductByCategory(String category) {
		
		Session session = getSession();
		Query query = session.createQuery("from Product where category = :category");
		query.setString("category", category);
		return query.list();
	}
}
