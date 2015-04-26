package com.fot.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.fot.dao.OrderDAO;
import com.fot.model.Address;
import com.fot.model.CartItem;
import com.fot.model.Order;
import com.fot.model.Product;
import com.fot.model.ShoppingCart;
import com.fot.model.User;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/OrderController")
public class OrderController extends BaseController {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(("History").equals(request.getParameter("page"))){
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute(CURRENT_USER);
			request.setAttribute(ORDER_LIST, OrderDAO.getOrders(user.getUsername()));
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("history.jsp");
			dispatcher.forward(request, response);
	
			return;
		}
		
		else{
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute(CURRENT_USER);
			request.setAttribute(ORDER_LIST, OrderDAO.cancelOrders(user.getUsername(),"Order Placed"));
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("cancel.jsp");
			dispatcher.forward(request, response);
	
			return;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		HttpSession session = request.getSession();
		if(("CancelOrder").equals(request.getParameter("action"))){
			System.out.println(request.getParameter("orderId"));
			int orderId = Integer.parseInt(request.getParameter("orderId"));
			OrderDAO.deleteOrder(orderId);
			
			User user = (User) session.getAttribute(CURRENT_USER);
			request.setAttribute(ORDER_LIST, OrderDAO.cancelOrders(user.getUsername(),"Order Placed"));
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("cancel.jsp");
			dispatcher.forward(request, response);
	
			return;
		}
		
		else{
			String apt, zip, streetName, city, state, time, today,status;
			int orderId;
			apt = request.getParameter("apt");
			city = request.getParameter("city");
			state = request.getParameter("state");
			zip = request.getParameter("zipCode");
			streetName = request.getParameter("streetName");
			time = request.getParameter("deliveryTime");
			today = request.getParameter("orderDate");
			status = "Order Placed";
			
			Address address = new Address(apt,streetName,city,state,zip);
			String user_address = address.getFullAddress();
			String products="";
			int i=0;
			
			User user = (User) session.getAttribute(CURRENT_USER);
			
			orderId = OrderDAO.getOrderId() + 1;
			
			Double totalCost = (Double) session.getAttribute(TOTAL_PRICE);
			
			ShoppingCart cart = (ShoppingCart) session.getAttribute(SHOPPING_CART);
			List<CartItem> myCart = (List<CartItem>) cart.getList();		
		    
			for(i=0;i<myCart.size()-1;i++){
				Product myProduct = myCart.get(i).getProduct();
			    
			    //Order products = new Order(myProduct.getProductCode(),myProduct.getProductName(),myCart.get(i).getQuantity(),myProduct.getProductCost()*myCart.get(i).getQuantity());
			    //OrderDAO.saveProducts(products);
				
				products +=myProduct.getProductName()+"  -  "+ myCart.get(i).getQuantity()+",";
			}
			Product myProduct = myCart.get(i).getProduct();
			products +=myProduct.getProductName()+"  -  "+ myCart.get(i).getQuantity();
			Order order = new Order(orderId,user.getUsername(),user_address,time,today,totalCost,products,status);
			OrderDAO.saveOrder(order);	
			
			session.setAttribute("apt", apt);
			session.setAttribute("city", city);
			session.setAttribute("state", state);
			session.setAttribute("zipCode", zip);
			session.setAttribute("streetName", streetName);
			session.setAttribute("deliveryTime", time);
			response.sendRedirect("Success.jsp");
		}		
	}

}
