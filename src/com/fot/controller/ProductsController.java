package com.fot.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fot.dao.ProductDAO;
import com.fot.util.Util;

/**
 * Servlet implementation class ProductsController
 */
@WebServlet("/ProductsController")
public class ProductsController extends HttpServlet {
	private static final String PRODUCT_CODE = "ProductCode";
	private static final long serialVersionUID = 1L;

	public ProductsController() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String productCode = request.getParameter(PRODUCT_CODE);
		if (!Util.isEmpty(productCode)) {
			request.setAttribute("product",
					ProductDAO.getProductByCode(productCode));
			// Write code to dispatch to correct JSP
			return;
		}

		String productCategory = request.getParameter("ProductCategory");
		if (!Util.isEmpty(productCategory)) {
			request.setAttribute("productList",
					ProductDAO.getProductByCategory(productCategory));
			// Write code to dispatch to correct JSP
			return;
		}

		// if no parameter is passed return all the products
		request.setAttribute("productList", ProductDAO.getAll());
		// Write code to dispatch to correct JSP
		return;
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

}
