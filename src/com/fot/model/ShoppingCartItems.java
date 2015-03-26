package com.fot.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShoppingCartItems {
	static List<Product> cartItems = new ArrayList<Product>();
	static int numberOfItems;
	static int total;

	public ShoppingCartItems() {
		cartItems = new ArrayList<Product>();
		numberOfItems = 0;
		total = 0;
	}

	public static void addItem(Product product, int quantity) {
		int qty = 0;
		qty = quantity;
		boolean newItem = true;
		if (cartItems != null) {
			for (Product item : cartItems) {

				if (item.getProductCode() == product.getProductCode()) {

					newItem = false;
					// item.incrementQuantity();
					item.setQuantity(qty);
				}
			}
			if (newItem) {
				cartItems.add(product);
			}
		}

	}

	public static void deleteItem(Product product) {
		if (cartItems != null) {
			Iterator<Product> item = cartItems.iterator();
			while (item.hasNext()) {
				Product pro = item.next();
				if (pro.getProductCode().equals(product.getProductCode())) {
					item.remove();

				}
			}
		}

	}

	public static List<Product> getList() {
		return cartItems;
	}

	public static void update(Product product, int quantity) {

		int qty = 0;
		qty = quantity;

		if (qty >= 0) {
			for (Product cItem : cartItems) {

				if (cItem.getProductCode().equals(product.getProductCode())) {
					if (qty != 0) {
						cItem.setQuantity(qty);
					}
				}
			}
		}
	}

	public static int getNumberOfItems() {
		numberOfItems = 0;

		for (Product item : cartItems) {
			numberOfItems = numberOfItems + item.getQuantity();
		}

		return numberOfItems;
	}

	public static Double getTotalPrice() {
		double total = 0;

		for (Product item : cartItems) {
			total = total + (item.getQuantity() * item.getProductCost());

		}

		return total;
	}

	public static void clear() {
		cartItems.clear();
		numberOfItems = 0;
		total = 0;
	}

}