package com.fot.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
			
		//	RequestDispatcher dispatcher = request.getRequestDispatcher("menu.jsp");
		//	dispatcher.forward(request, response);
			
			return;
		}

		String productCategory = request.getParameter("ProductCategory");
		
		if("All".equals(productCategory))
        {
        	//System.out.println("This is from all");
        	request.setAttribute("productList", ProductDAO.getAll());
        }
		
		if (!Util.isEmpty(productCategory) && !productCategory.equals("All") ) {
			
			request.setAttribute("productList",
					ProductDAO.getProductByCategory(productCategory));
		
			
			//RequestDispatcher dispatcher = request.getRequestDispatcher("menu.jsp");
			//dispatcher.forward(request, response);
			
			
			return;
		}
		
		
		
		//Dispatching to menu.jsp
		RequestDispatcher dispatcher = request.getRequestDispatcher("menu.jsp");
		dispatcher.forward(request, response);
		
		return;
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

}
