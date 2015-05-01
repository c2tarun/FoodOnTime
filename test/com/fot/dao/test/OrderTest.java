package com.fot.dao.test;

import org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import com.fot.dao.OrderDAO;
import com.fot.model.Order;

public class OrderTest {

	@Test
	public  void testSaveOrder(){
		OrderDAO.deleteOrder(1);
		Order order = new Order(1,"Test User","123,XXX,YYY,ZZZ-29301","2015-04-28 15:00:00","2015-04-26",30.0,"Buscuits  -  3","Order Placed");
		OrderDAO.saveOrder(order);
		Assert.assertTrue(true);
		OrderDAO.deleteOrder(1);
	}
	
	@Test
	public  void testGetOrderId(){
		int count = OrderDAO.getOrderId();
		Assert.assertNotNull(count);
	}

	@Test
	public  void testGetOrders(){
		OrderDAO.deleteOrder(1);
		Order order = new Order(1,"Test User","123,XXX,YYY,ZZZ-29301","2015-04-28 15:00:00","2015-04-26",30.0,"Buscuits  -  3","Order Placed");
		OrderDAO.saveOrder(order);
		Assert.assertTrue(OrderDAO.getOrders("Test User").size() > 0);
		OrderDAO.deleteOrder(1);
	}
	
	@Test
	public  void testGetOrderById(){
		OrderDAO.deleteOrder(1);
		Order order = new Order(1,"Test User","123,XXX,YYY,ZZZ-29301","2015-04-28 15:00:00","2015-04-26",30.0,"Buscuits  -  3","Order Placed");
		OrderDAO.saveOrder(order);
		Assert.assertNotNull(OrderDAO.getOrderById(1));
		OrderDAO.deleteOrder(1);
	}
	
	@Test
	public  void testGetAllOrders(){
		OrderDAO.deleteOrder(1);
		Order order = new Order(1,"Test User","123,XXX,YYY,ZZZ-29301","2015-04-28 15:00:00","2015-04-26",30.0,"Buscuits  -  3","Order Placed");
		OrderDAO.saveOrder(order);
		Assert.assertTrue(OrderDAO.getOrders("Order Placed").size() > 0);
		OrderDAO.deleteOrder(1);
	}
	
	@Test
	public  void testCancelOrders(){
		OrderDAO.deleteOrder(1);
		Order order = new Order(1,"Test User","123,XXX,YYY,ZZZ-29301","2015-04-28 15:00:00","2015-04-26",30.0,"Buscuits  -  3","Order Placed");
		OrderDAO.saveOrder(order);
		Assert.assertTrue(OrderDAO.cancelOrders("Test User","Order Placed").size() > 0);
		OrderDAO.deleteOrder(1);
	}
	
	@Test
	public  void testDeleteOrder(){
		OrderDAO.deleteOrder(1);
		Order order = new Order(1,"Test User","123,XXX,YYY,ZZZ-29301","2015-04-28 15:00:00","2015-04-26",30.0,"Buscuits  -  3","Order Placed");
		OrderDAO.saveOrder(order);
		OrderDAO.deleteOrder(1);
		Assert.assertTrue(OrderDAO.cancelOrders("Test User","Order Placed").size() == 0);
		Assert.assertTrue(OrderDAO.getOrders("Test User").size() == 0);
	}
	
	@Test
	public void testAcceptOrder(){
		OrderDAO.deleteOrder(1);
		Order order = new Order(1,"Test User","123,XXX,YYY,ZZZ-29301","2015-04-28 15:00:00","2015-04-26",30.0,"Buscuits  -  3","Order Placed");
		OrderDAO.saveOrder(order);
		OrderDAO.acceptOrder(order);
		Assert.assertTrue(OrderDAO.getAllOrders("Order Placed").size() == 0);
	}
}
