package com.fot.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fot.dao.OrderDAO;
import com.fot.model.Address;
import com.fot.model.Order;
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
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String apt, zip, streetName, city, state, time, today;
		apt = request.getParameter("apt");
		city = request.getParameter("city");
		state = request.getParameter("state");
		zip = request.getParameter("zipCode");
		streetName = request.getParameter("streetName");
		time = request.getParameter("deliveryTime");
		today = request.getParameter("orderDate");
		
		Address address = new Address(apt,streetName,city,state,zip);
		
		User user = (User) session.getAttribute(CURRENT_USER);
		
		Order order = new Order(user.getUsername(),address,time,today);
		OrderDAO.saveOrder(order);
		
		/* response.setContentType("text/html");
		    PrintWriter out = response.getWriter();
		out.print("<html><body>");
		out.print("<p>"+user.getUsername()+"<br/></p>");
		out.print("</body></html>");*/
		
		session.setAttribute("apt", apt);
		session.setAttribute("city", city);
		session.setAttribute("state", state);
		session.setAttribute("zipCode", zip);
		session.setAttribute("streetName", streetName);
		session.setAttribute("deliveryTime", time);
		response.sendRedirect("Success.jsp");

	}

}
