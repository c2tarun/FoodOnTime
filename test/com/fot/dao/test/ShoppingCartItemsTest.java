package com.fot.dao.test;

import org.junit.Assert;
import org.junit.Test;
import com.fot.model.Product;
import com.fot.model.ShoppingCartItems;

public class ShoppingCartItemsTest {

	Product pro1 = new Product(
			"PR1",
			"Blueberry Scone",
			"bakery",
			"The light biscuit texture provides the ideal backdrop for a bounty of dried blueberries and lemon zest. Sweet yet tart, our classic Blueberry Scone calls for a balanced coffee, such as House Blend",
			"http://globalassets.starbucks.com/assets/ea8adb19d1894a7e930b218c0112c357.jpg", 5, 5);

	@Test
	public void addItemTest() {

		ShoppingCartItems.addItem(pro1,2);
		Assert.assertTrue(ShoppingCartItems.getList().size() > 0);
	}

	@Test
	public void numberOFItemsTest() {
		ShoppingCartItems.addItem(pro1,5);
		ShoppingCartItems.update(pro1, 5);
		Assert.assertTrue(ShoppingCartItems.getNumberOfItems() == 5);
	}

	@Test
	public void getCartListTest() {
		ShoppingCartItems.addItem(pro1,5);
		Assert.assertTrue(ShoppingCartItems.getList().size() > 0);
	}

	@Test
	public void clearCartListTest() {
		ShoppingCartItems.addItem(pro1,2);
		ShoppingCartItems.clear();
		Assert.assertTrue(ShoppingCartItems.getList().size() == 0);
	}

	@Test
	public void deleterCartItemTest() {
		ShoppingCartItems.addItem(pro1,2);
		ShoppingCartItems.deleteItem(pro1);
		Assert.assertTrue(ShoppingCartItems.getList().size() == 0);
	}

	@Test
	public void updateCartQuantityTest() {
		ShoppingCartItems.addItem(pro1,2);
		ShoppingCartItems.update(pro1, 4);
		Assert.assertTrue(pro1.getQuantity() == 4);
	}
}
