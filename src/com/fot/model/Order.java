package com.fot.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

@Entity
@Table(name = "USER_ORDER")
//@SecondaryTable(name = "user_products")
public class Order implements Serializable{

	@Id
	@Column(name = "orderId")
	private int orderId;

	@Column(name = "user_id" , table = "user_order")
	private String user;
	
	@Column(name = "order_date" , table = "user_order")
	private String orderDate;
	
	@Column(name = "address" , table = "user_order")	
	private String address;
	
	//private List<CartItem> items;
	@Column(name = "delivery_date" , table = "user_order")
	private String deliveryDate;
	
	@Column(name = "totalCost" , table = "user_order")
	private double totalCost;
	
	@Column(name = "products" , table = "user_order")
	private String products;
	
	/*@Column(name = "productId" , table = "user_products")
	private String productId;
	
	@Column(name = "productName" , table = "user_products")
	private String productName;
	
	@Column(name = "quantity" , table = "user_products")
	private int quantity;
	
	@Column(name = "cost" , table = "user_products")
	private double cost;*/

	public Order(){
		
	}
	
	public Order(int orderId,String user,String address,String deliveryDate,String orderDate,double totalCost,String products){
		super();
		this.orderId = orderId;
		this.user = user;
		this.address = address;
		this.deliveryDate = deliveryDate;
		this.orderDate = orderDate; 
		this.totalCost = totalCost;
		this.products = products;
	}
	
	/*public Order(String productId,String productName,int quantity,double cost){
		super();
		this.productId = productId;
		this.productName = productName;
		this.quantity = quantity;
		this.cost = cost;
	}
	
	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}*/
	
	public String getProducts() {
		return products;
	}

	public void setProducts(String products) {
		this.products = products;
	}
	
	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	/*public List<CartItem> getItems() {
		return items;
	}

	public void setItems(List<CartItem> items) {
		this.items = items;
	}*/

}
