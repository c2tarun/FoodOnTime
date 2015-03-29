package com.fot.dao.test;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.fot.model.Product;
import com.fot.model.ShoppingCart;

public class ShoppingCartTest {

	Product pro1 = new Product(
			"PR1",
			"Blueberry Scone",
			"bakery",
			"The light biscuit texture provides the ideal backdrop for a bounty of dried blueberries and lemon zest. Sweet yet tart, our classic Blueberry Scone calls for a balanced coffee, such as House Blend®.",
			"http://globalassets.starbucks.com/assets/ea8adb19d1894a7e930b218c0112c357.jpg",2.5);

	static ShoppingCart cart;
	
	@BeforeClass
	public static void init() {
		cart = new ShoppingCart();
	}
	
	@Test
	public void addItemTest() {

		cart.addItem(pro1);
		Assert.assertTrue(cart.getList().size() > 0);
	}

	@Test
	public void numberOFItemsTest() {
		cart.clear();
		cart.addItem(pro1);
		Assert.assertTrue(cart.getItem(pro1).getQuantity() == 1);
	}

	@Test
	public void getCartListTest() {
		cart.addItem(pro1);
		Assert.assertTrue(cart.getList().size() > 0);
	}

	@Test
	public void clearCartListTest() {
		cart.addItem(pro1);
		cart.clear();
		Assert.assertTrue(cart.getList().size() == 0);
	}

	@Test
	public void deleterCartItemTest() {
		cart.addItem(pro1);
		cart.deleteItem(pro1);
		Assert.assertTrue(cart.getItem(pro1) == null);
	}

	@Test
	public void updateCartQuantityTest() {
		cart.addItem(pro1);
		cart.update(pro1, 4);
		Assert.assertTrue(cart.getItem(pro1).getQuantity() == 4);
	}
}
