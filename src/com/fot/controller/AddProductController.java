package com.fot.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fot.dao.ProductDAO;
import com.fot.dao.UserDAO;
import com.fot.model.Product;
import com.fot.model.User;

/**
 * Servlet implementation class AddProductController
 */
@WebServlet("/AddProductController")
public class AddProductController extends BaseController {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			Product productCheck = ProductDAO.getProductByCode((String) request.getParameter(PRODUCT_CODE));
			if ((productCheck == null)) {
				String cost= request.getParameter(PRODUCT_COST);
				double productCost = Double.parseDouble(cost);
				Product product = new Product((String) request.getParameter(PRODUCT_CODE),
						(String) request.getParameter(PRODUCT_NAME),
						(String) request.getParameter(CATEGORY),
						(String) request.getParameter(PRODUCT_DESC),
						(String) request.getParameter(IMAGE_URL), productCost);
				ProductDAO.saveProduct(product);
						response.sendRedirect("ProductsController");
			}

			else {
				request.setAttribute(MESSAGE, "Product Exists");
				
				request.setAttribute("productCode",(String) request.getParameter(PRODUCT_CODE));
				request.setAttribute("productName",(String) request.getParameter(PRODUCT_NAME));
				request.setAttribute("description",(String) request.getParameter(PRODUCT_DESC));
				request.setAttribute("productCost",(String) request.getParameter(PRODUCT_COST));
				request.setAttribute("imageUrl",(String) request.getParameter(IMAGE_URL));
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("Addadmin.jsp");
				dispatcher.forward(request, response);
			}
	}

}
