package com.fot.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fot.dao.UserDAO;
import com.fot.util.Util;
import com.fot.model.User;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/UserController")
public class UserController extends BaseController {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}	
		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		if(("registration").equals((String) request.getParameter("loginType"))){
			User userCheck = UserDAO.getUserByUsername((String) request.getParameter("userName"));
			
			if((userCheck == null)){
				User user = new User((String) request.getParameter("userName"),
									 (String) request.getParameter("password"),
									 (String) request.getParameter("firstName"),
									 (String) request.getParameter("lastName"),
									 (String) request.getParameter("emailID"));
				UserDAO.saveUser(user);
				
				request.setAttribute(MESSAGE, "Registration Complete. Please Login");
				RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
				dispatcher.forward(request, response);
			}
			
			else{
				request.setAttribute(MESSAGE, "User Exists");
				RequestDispatcher dispatcher = request.getRequestDispatcher("registeration.jsp");
				dispatcher.forward(request, response);
			}
		}
	
	//login 
		
		
	
	}
		
		

	}


