package com.fot.model;

public class Product {

	private String productCode;
	private String productName;
	private String category;
	private String description;
	private String imageUrl;

	public Product() {

	}

	public Product(String productCode, String productName, String category,
			String description, String imageUrl) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.category = category;
		this.description = description;
		this.imageUrl = imageUrl;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

}