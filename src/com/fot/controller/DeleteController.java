package com.fot.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fot.dao.ProductDAO;
import com.fot.model.ShoppingCartItems;

/**
 * Servlet implementation class TestController
 */
@WebServlet("/DeleteController")
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteController() {
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
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		ShoppingCartItems cart = (ShoppingCartItems) session.getAttribute("shoppingCart");
		if (cart == null) { // No cart already in session
			cart = new ShoppingCartItems();
			session.setAttribute("shoppingCart", cart);
		}
		
		String delPid;
		delPid = request.getParameter("delPid");
		String delete="false";
		delete = request.getParameter("delete");
		
		
		if(delete.equals("true"))
		{
			cart.deleteItem(ProductDAO.getProductByCode(delPid));
		}
		session.setAttribute("CartList", cart.getList());
		session.setAttribute("NumberOfItems", cart.getNumberOfItems());
		session.setAttribute("TotalPrice", cart.getTotalPrice());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Cart.jsp");
		dispatcher.forward(request, response);
	}

}
