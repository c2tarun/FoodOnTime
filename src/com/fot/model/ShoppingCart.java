package com.fot.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShoppingCart implements Serializable {
	static List<CartItem> cartItems = new ArrayList<CartItem>();
	static int numberOfItems;
	static int total;

	public ShoppingCart() {
		cartItems = new ArrayList<CartItem>();
		numberOfItems = 0;
		total = 0;
	}

	public CartItem getItem(Product product) {
		if (cartItems != null && cartItems.contains(new CartItem(product))) {
			for(CartItem item : cartItems) {
				if(item.getProduct().getProductCode().equals(product.getProductCode())) {
					return item;
				}
			}
		}
		return null;
	}

	public void addItem(Product product) {

		boolean newItem = true;
		if (cartItems != null) {
			for (CartItem item : cartItems) {

				if (item.getProduct().getProductCode().equals(product
						.getProductCode())) {
					newItem = false;
					item.incrementQuantity();
					break;
				}
			}
			if (newItem) {
				CartItem newCartItem = new CartItem(product);
				cartItems.add(newCartItem);
			}
		}

	}

	public void deleteItem(Product product) {
		if (cartItems != null) {
			cartItems.remove(new CartItem(product));
		}

	}

	public List<CartItem> getList() {
		return cartItems;
	}

	public void update(Product product, int quantity) {

		int qty = 0;
		qty = quantity;

		if (qty >= 0) {

			for (CartItem cItem : cartItems) {
				if (cItem.getProduct().getProductCode()
						.equals(product.getProductCode())) {
					if (qty != 0) {
						cItem.setQuantity(qty);
					}
				}
			}
		}
	}

	public int getNumberOfItems() {
		numberOfItems = 0;
		for (CartItem item : cartItems) {
			numberOfItems = numberOfItems + item.getQuantity();
		}
		return numberOfItems;
	}

	public Double getTotalPrice() {
		double total = 0d;

		for (CartItem item : cartItems) {
			// total=item.getQuantity() * item.getPrice().doubleValue();;
			total = total + item.getQuantity()
					* item.getProduct().getProductCost();
		}

		return total;
	}

	public void clear() {
		cartItems.clear();
		numberOfItems = 0;
		total = 0;
	}

}