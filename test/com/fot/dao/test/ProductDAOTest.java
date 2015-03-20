package com.fot.dao.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.fot.dao.ProductDAO;
import com.fot.model.Product;

public class ProductDAOTest {
	
	@Test
	public void getAllTest() {
		List<Product> products = ProductDAO.getAll();
		Assert.assertTrue(products.size() > 0);
	}

}