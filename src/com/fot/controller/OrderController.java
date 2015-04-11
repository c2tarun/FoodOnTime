package com.fot.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/OrderController")
public class OrderController extends HttpServlet {
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
		String apt, zip, streetName, city, state;
		apt = request.getParameter("apt");
		city = request.getParameter("city");
		state = request.getParameter("state");
		zip = request.getParameter("zipCode");
		streetName = request.getParameter("streetName");

		session.setAttribute("apt", apt);
		session.setAttribute("city", city);
		session.setAttribute("state", state);
		session.setAttribute("zipCode", zip);
		session.setAttribute("streetName", streetName);
		response.sendRedirect("Success.jsp");

	}

}
