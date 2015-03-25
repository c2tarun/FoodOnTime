package com.fot.model;

public class Product {

	private String productCode;
	private String productName;
	private String category;
	private String description;
	private String imageUrl;
<<<<<<< HEAD
	private double productCost;

=======
	int quantity;
>>>>>>> 88935ef39761cffb600d4532a75b6fc30511d575
	public Product() {

	}

	public Product(String productCode, String productName, String category,
<<<<<<< HEAD
			String description, String imageUrl, double productCost) {
=======
			String description, String imageUrl,int quantity) {
>>>>>>> 88935ef39761cffb600d4532a75b6fc30511d575
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.category = category;
		this.description = description;
		this.imageUrl = imageUrl;
<<<<<<< HEAD
		this.productCost = productCost;
=======
		this.quantity=quantity;
>>>>>>> 88935ef39761cffb600d4532a75b6fc30511d575
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
<<<<<<< HEAD
	
	public double getProductCost() {
		return productCost;
	}

	public void setProductCost(double productCost) {
		this.productCost = productCost;
=======
	 
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
	 
	public double getTotal() {
	double amount = 0;
	//amount = (this.getQuantity() * this.getPrice().doubleValue());
	return amount;
>>>>>>> 88935ef39761cffb600d4532a75b6fc30511d575
	}

}
