package com.fot.model;

import java.io.Serializable;

public class CartItem implements Serializable {

	private Product product;
	private int quantity;
	private static final int DEFAULT_QUANTITY = 1;
	public CartItem(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}

	public CartItem(Product product) {
		this(product, DEFAULT_QUANTITY);
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void incrementQuantity() {
		quantity++;
	}

	public void decrementQuantity() {
		quantity--;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartItem other = (CartItem) obj;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.getProductCode().equals(other.product.getProductCode()))
			return false;
		return true;
	}
	
	

}
