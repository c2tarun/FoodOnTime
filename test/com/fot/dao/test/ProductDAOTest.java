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

	@Test
	public void getProductByCodeTest() {
		Product product = ProductDAO.getProductByCode("PR1");
		Assert.assertNotNull(product);
	}

	@Test
	public void getProductByCategoryTest() {
		List<Product> products = ProductDAO.getProductByCategory("bakery");
		Assert.assertNotNull(products);
		Assert.assertTrue(products.get(0).getCategory().equals("bakery"));
	}

	@Test
	public void adminProductTest() {
		Product pro1 = new Product(
				"PR69",
				"Blueberry Scone",
				"bakery",
				"The light biscuit texture provides the ideal backdrop for a bounty of dried blueberries and lemon zest. Sweet yet tart, our classic Blueberry Scone calls for a balanced coffee, such as House Blend®.",
				"http://globalassets.starbucks.com/assets/ea8adb19d1894a7e930b218c0112c357.jpg", 2.5);
		ProductDAO.saveProduct(pro1);
		Assert.assertNotNull(ProductDAO.getProductByCode("PR68"));
		pro1.setCategory("fastfood");
		ProductDAO.updateProduct(pro1);
		Assert.assertNotNull(ProductDAO.getProductByCategory("fastfood"));
		ProductDAO.deleteProductByCode("PR69");
	}
}
