package com.fot.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fot.dao.ProductDAO;
import com.fot.model.Product;

/**
 * Servlet implementation class UpdateProductController
 */
@WebServlet("/UpdateProductController")
public class UpdateProductController extends BaseController {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String productCode = request.getParameter(PRODUCT_CODE);
		Product productToUpdate = ProductDAO.getProductByCode(productCode);
		productToUpdate.setCategory(request.getParameter(CATEGORY));
		productToUpdate.setDescription(request.getParameter(PRODUCT_DESC));
		productToUpdate.setImageUrl(request.getParameter(IMAGE_URL));
		double cost;
		try{
		cost = Double.parseDouble(request.getParameter(PRODUCT_COST));
		}catch(NumberFormatException n) {
			request.setAttribute(MESSAGE, "Invalid price");
			cost = productToUpdate.getProductCost();
			request.getRequestDispatcher("editProduct.jsp").forward(request, response);
			return;
		}
		productToUpdate.setProductCost(cost);
		productToUpdate.setProductName(request.getParameter(PRODUCT_NAME));
		ProductDAO.updateProduct(productToUpdate);
		request.getRequestDispatcher(
				"ProductsController?" + PRODUCT_CODE + "=")
				.forward(request, response);
		return;
	}

}
