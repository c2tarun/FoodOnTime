package com.fot.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER_ORDER")
public class Order {

	@Id
	@Column(name = "user_id")
	private String user;
	
	@Id
	@Column(name = "order_date")
	private String orderDate;
	
	@Column(name = "address")
	private Address address;
	//private List<CartItem> items;
	@Column(name = "address")
	private String deliveryDate;
	

	public Order(){
		
	}
	
	public Order(String user,Address address,String deliveryDate,String orderDate){
		super();
		this.user = user;
		this.address = address;
		this.deliveryDate = deliveryDate;
		this.orderDate = orderDate; 
		
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	/*public List<CartItem> getItems() {
		return items;
	}

	public void setItems(List<CartItem> items) {
		this.items = items;
	}*/

}
