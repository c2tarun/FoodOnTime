package com.fot.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fot.dao.ProductDAO;
import com.fot.model.User;
import com.fot.util.Util;

/**
 * Servlet implementation class ProductsController
 */
@WebServlet("/ProductsController")
public class ProductsController extends BaseController {

	private static final long serialVersionUID = 1L;

	public ProductsController() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String productCode = request.getParameter(PRODUCT_CODE);
		HttpSession session = request.getSession();
		if (!Util.isEmpty(productCode)) {
			request.setAttribute(PRODUCT,
					ProductDAO.getProductByCode(productCode));
			User currentUser = (User) session.getAttribute(CURRENT_USER);
			if ("Admin".equalsIgnoreCase(currentUser.getStatus())) {
				request.getRequestDispatcher("editProduct.jsp").forward(
						request, response);
			} else {
				request.getRequestDispatcher("Description.jsp").forward(
						request, response);
			}
			return;
		}

		String productCategory = request.getParameter(PRODUCT_CATEGORY);

		if (!Util.isEmpty(productCategory) && !productCategory.equals(ALL)) {
			request.setAttribute(PRODUCT_LIST,
					ProductDAO.getProductByCategory(productCategory));

			request.setAttribute(PRODUCT_CATEGORY, productCategory);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("menu.jsp");
			dispatcher.forward(request, response);

			return;
		}

		// if no parameter is passed return all the products
		request.setAttribute(PRODUCT_LIST, ProductDAO.getAll());

		// Dispatching to menu.jsp
		RequestDispatcher dispatcher = request.getRequestDispatcher("menu.jsp");
		dispatcher.forward(request, response);

		return;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
