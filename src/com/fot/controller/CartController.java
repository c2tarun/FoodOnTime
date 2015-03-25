package com.fot.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fot.model.ShoppingCartItems;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String quantity;
		
		//request.setAttribute("Clear", ShoppingCartItems.clear());
		HttpSession session = request.getSession();
	       ShoppingCartItems cart =  (ShoppingCartItems) session.getAttribute ("ShoppingCartItems");
	    
	      // if the session is new, the cart won't exist.
	      if (cart == null)
	      {
	    	  cart = new ShoppingCartItems();
	         session.setAttribute ("cart", cart);
	       
	      }
	      session.setAttribute("CartList", ShoppingCartItems.getList());
	 		
	      session.setAttribute("NumberOfItems", ShoppingCartItems.getNumberOfItems());
	 		
	      session.setAttribute("TotalPrice", ShoppingCartItems.getTotalPrice());
	 		
	 		quantity=request.getParameter("quantity");
	 		
	 		
	 		//ShoppingCartItems.addItem(product);
	 		//ShoppingCartItems.deleteItem(product);
	 		
	 		//ShoppingCartItems.update(product, quantity);
	 		
	 		ShoppingCartItems.clear();
	}


	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
