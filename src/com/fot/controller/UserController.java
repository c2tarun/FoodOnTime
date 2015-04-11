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
import com.fot.model.User;
import com.fot.util.Util;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		// TODO Auto-generated method stub

		if (REGISTRATION.equals((String) request.getParameter(LOGIN_TYPE))) {
			User userCheck = UserDAO.getUserByUsername((String) request.getParameter(USERNAME));
			if ((userCheck == null)) {
				User user = new User((String) request.getParameter(USERNAME),
						(String) request.getParameter(PASSWORD), (String) request.getParameter(FIRST_NAME),
						(String) request.getParameter(LAST_NAME), (String) request.getParameter(EMAIL_ID), null);
				UserDAO.saveUser(user);
				request.setAttribute(MESSAGE, "Registration Complete. Please Login");
				RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
				dispatcher.forward(request, response);
			}

			else {
				request.setAttribute(MESSAGE, "User Exists");
				RequestDispatcher dispatcher = request.getRequestDispatcher("registeration.jsp");
				dispatcher.forward(request, response);
			}

		}

		// User Controller for login

		String Username = request.getParameter(USERNAME);
		String Password = request.getParameter(PASSWORD);
		String userLogValue = "false";

		User userCheck = UserDAO.getUserByUsername(Username);
		HttpSession session = request.getSession();

		if (userCheck != null && !Util.isEmpty(Username) && !Util.isEmpty(Password)) {
			String User_name = userCheck.getUsername();
			String pass_word = userCheck.getPassword();

			if (Username.equals(User_name) && Password.equals(pass_word)) {

				session.setAttribute(CURRENT_USER, userCheck);

				userLogValue = (String) session.getAttribute("userLog");
				if (userLogValue == null) {
					response.sendRedirect("index.jsp");

				} else if (userLogValue.equals("true")) {
					response.sendRedirect("checkout.jsp");
				}

			} else {
				session.setAttribute(CURRENT_USER, null);
				request.setAttribute(MESSAGE, "Login Not successful.");
				RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
				dispatcher.forward(request, response);

			}
		} else {

			request.setAttribute(MESSAGE, "Login Not successful.");
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);

		}
	}
}
