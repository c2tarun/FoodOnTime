package com.fot.dao;

import java.util.ArrayList;
import java.util.List;

import com.fot.model.Product;

public final class ProductDAO {

	public static List<Product> getAll() {
		List<Product> products = new ArrayList<Product>();
		Product pro1 = new Product(
				"PR1",
				"Blueberry Scone",
				"bakery",
				"The light biscuit texture provides the ideal backdrop for a bounty of dried blueberries and lemon zest. Sweet yet tart, our classic Blueberry Scone calls for a balanced coffee, such as House Blend.",
				"http://globalassets.starbucks.com/assets/ea8adb19d1894a7e930b218c0112c357.jpg", 5.0);	
		
		Product pro2 = new Product(
				"PR2",
				"Almond Croissant Blossom",
				"bakery",
				"Our traditionally inspired recipe begins with butter, wheat flour and vanilla. For the grand finale, we top each one with a sweet almond filling and toasted sliced almonds. Perfect with a cup of your favorite brewed coffee.",
				"http://globalassets.starbucks.com/assets/40f7717f835d4e3199bb4406e205b40e.jpg", 6.0);
				

		Product pro3 = new Product(
				"PR3",
				"Bacon & Gouda Breakfast Sandwich",
				"breakfast",
				"The light biscuit texture provides the ideal backdrop for a bounty of dried blueberries and lemon zest. Sweet yet tart, our classic Blueberry Scone calls for a balanced coffee, such as House Blend.",
				"http://globalassets.starbucks.com/assets/ea8adb19d1894a7e930b218c0112c357.jpg", 7.0);
			
		Product pro4 = new Product(
				"PR4",
				"Ham & Cheddar Breakfast Sandwich",	
				"breakfast",
				"This is kind of like your typical ham, egg and cheese breakfast sandwich. Only with better cheese. And instead of scrambled eggs, you get frittata. With Parmesan. On a hand-scored artisan roll. See? Just like the sandwich you are used to except delightfully different. ",
				"http://globalassets.starbucks.com/assets/0f250d904ffd418cb2edc0e3596fe5ed.jpg", 5.0);

		Product pro5 = new Product(
				"PR5",
				"Cheese & Fruit Bistro Box",
				"bistro box",
				"A trio of cheeses: creamy Brie, bold Gouda, two year aged Cheddar, grain crackers, green apple wedges and a mix of roasted almonds and tart dried cranberries.",
				"http://globalassets.starbucks.com/assets/8bdae8a56b014a8ba1ca624ce19ed856.jpg", 6.0);

		Product pro6 = new Product(
				"PR6",
				"Chicken & Hummus Bistro Box",
				"bakery",
				"Traditional chick pea hummus and grilled chicken served with grape tomatoes, cucumber sticks and whole wheat pita halves.",
				"http://globalassets.starbucks.com/assets/8d64ec2ecc6b4afdbb6aec25d132a1ce.jpg", 4.0);
		
		products.add(pro1);
		products.add(pro2);
		products.add(pro3);
		products.add(pro4);
		products.add(pro5);
		products.add(pro6);

		return products;
	}

	public static Product getProductByCode(String id) {
		List<Product> products = getAll();
		for(Product product : products) {
			if(product.getProductCode().equals(id)) {
				return product;
			}
		}
		return null;
	}
	
	public static List<Product> getProductByCategory(String category) {
		List<Product> products = getAll();
		List<Product> categorisedProducts = new ArrayList<Product>();
		for(Product product : products) {
			if(product.getCategory().equals(category)) {
				categorisedProducts.add(product);
			}
		}
		return categorisedProducts;
	}

}
