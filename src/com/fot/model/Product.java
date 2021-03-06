package com.fot.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PRODUCT")
public class Product implements Serializable{

	@Id
	private String productCode;
	private String productName;
	private String category;
	
	@Column(length=500)
	private String description;
	private String imageUrl;
	private double productCost;

	public Product() {

	}

	public Product(String productCode, String productName, String category,
			String description, String imageUrl, double productCost) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.category = category;
		this.description = description;
		this.imageUrl = imageUrl;
		this.productCost = productCost;
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

	public double getProductCost() {
		return productCost;
	}

	public void setProductCost(double productCost) {
		this.productCost = productCost;
	}

	public double getTotal() {
		double amount = 0;
		// amount = (this.getQuantity() * this.getPrice().doubleValue());
		return amount;

	}

}
