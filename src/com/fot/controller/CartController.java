package com.fot.controller;

import java.io.IOException;
import java.net.HttpRetryException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fot.dao.ProductDAO;
import com.fot.model.Product;
import com.fot.model.ShoppingCart;
import com.fot.util.Constants;
import com.fot.util.Util;

/**
 * Servlet implementation class CartController
 */
@WebServlet("/CartController")
public class CartController extends BaseController {

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
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String quantity;

		HttpSession session = request.getSession();
		ShoppingCart cart = (ShoppingCart) session.getAttribute(SHOPPING_CART);

		// if the session is new, the cart won't exist.
		if (cart == null) {
			cart = new ShoppingCart();
			session.setAttribute(SHOPPING_CART, cart);
		}

		if (request.getParameterMap().containsKey(UPDATE_PRODUCT)
				&& request.getParameterMap().containsKey(UPDATE_QUANTITY)) {
			String updateProduct = (String) request
					.getParameter(UPDATE_PRODUCT);
			int updateQuantity = Integer.parseInt(request
					.getParameter(UPDATE_QUANTITY));
			if (!Util.isEmpty(updateProduct) && updateQuantity != 0) {

				Product productToUpdate = ProductDAO
						.getProductByCode(updateProduct);
				cart.update(productToUpdate, updateQuantity);

				session.setAttribute(CART_LIST, cart.getList());
				session.setAttribute(TOTAL_PRICE, cart.getTotalPrice());

				request.getRequestDispatcher("Cart.jsp").forward(request,
						response);
			}

		}

		else {
			String productCode = (String) request.getParameter(PRODUCT_CODE);
			if (!Util.isEmpty(productCode)) {
				Product productToAdd = ProductDAO.getProductByCode(productCode);
				cart.addItem(productToAdd);
			}
			session.setAttribute(CART_LIST, cart.getList());
			session.setAttribute(TOTAL_PRICE, cart.getTotalPrice());
			String prodCategory = (String) request
					.getParameter(PRODUCT_CATEGORY);
			if (Util.isEmpty(prodCategory)) {
				request.getRequestDispatcher(
						"ProductsController?" + PRODUCT_CODE + "=")
						.forward(request, response);
			} else {
				request.getRequestDispatcher(
						"ProductsController?" + PRODUCT_CODE + "=&"
								+ PRODUCT_CATEGORY + "=" + prodCategory)
						.forward(request, response);
			}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession(true);
		ShoppingCart cart = (ShoppingCart) session.getAttribute(SHOPPING_CART);
		if (cart == null) { // No cart already in session
			cart = new ShoppingCart();
			session.setAttribute(SHOPPING_CART, cart);
		}

		String delPid;
		delPid = request.getParameter(DEL_PID);
		String delete = "false";
		delete = request.getParameter(DELETE);

		if (delete.equals("true")) {
			cart.deleteItem(ProductDAO.getProductByCode(delPid));
		}
		session.setAttribute(CART_LIST, cart.getList());
		session.setAttribute(TOTAL_PRICE, cart.getTotalPrice());
		RequestDispatcher dispatcher = request.getRequestDispatcher("Cart.jsp");
		dispatcher.forward(request, response);
	}

}
