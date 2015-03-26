package com.fot.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fot.dao.ProductDAO;
import com.fot.model.Product;
import com.fot.model.ShoppingCartItems;
import com.fot.util.Util;

/**
 * Servlet implementation class CartController
 */
@WebServlet("/CartController")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartController() {
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

		HttpSession session = request.getSession(true);
		ShoppingCartItems cart = (ShoppingCartItems) session.getAttribute("shoppingCart");
		if (cart == null) { // No cart already in session
			cart = new ShoppingCartItems();
			session.setAttribute("shoppingCart", cart);
		}
		String pId;
		pId = request.getParameter("pid");
		String pcost;
		pcost = request.getParameter("pcost");

		String productId = pId.substring(0, 3);
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		if (!Util.isEmpty(pId)) {
			cart.addItem(ProductDAO.getProductByCode(productId), quantity);
			cart.update(ProductDAO.getProductByCode(productId), quantity);
		}

		session.setAttribute("CartList", cart.getList());
		session.setAttribute("NumberOfItems", cart.getNumberOfItems());

		session.setAttribute("TotalPrice", cart.getTotalPrice());
		RequestDispatcher dispatcher = request.getRequestDispatcher("Cart.jsp");
		dispatcher.forward(request, response);

		/*
		 * if(delete.equals(true)) {
		 * cart.deleteItem(ProductDAO.getProductByCode(deleteId)); }
		 */

		// ShoppingCartItems.clear();
	}

}
