package com.fot.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fot.dao.ProductDAO;
import com.fot.util.Constants;
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

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String productCode = request.getParameter(PRODUCT_CODE);
		if (!Util.isEmpty(productCode)) {
			request.setAttribute(PRODUCT,
					ProductDAO.getProductByCode(productCode));
			return;
		}

		String productCategory = request.getParameter(PRODUCT_CATEGORY);
		
		if (!Util.isEmpty(productCategory) && !productCategory.equals(ALL)) {
			request.setAttribute(PRODUCT_LIST,
					ProductDAO.getProductByCategory(productCategory));

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

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

}
