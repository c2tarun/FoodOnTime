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
import com.fot.util.PasswordUtil;
import com.fot.util.Util;

/**
 * Servlet implementation class UserController
 */

@WebServlet("/UserController")
public class UserController extends BaseController {

	private static final String USERNAME_PASSWORD_INCORRECT = "Username password incorrect.";
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
	public void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	public void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		if (REGISTRATION.equals((String) request.getParameter(LOGIN_TYPE))) {
			User userCheck = UserDAO.getUserByUsername((String) request
					.getParameter(USERNAME));
			if ((userCheck == null)) {
				User user = new User((String) request.getParameter(USERNAME),
						(String) request.getParameter(PASSWORD),
						(String) request.getParameter(FIRST_NAME),
						(String) request.getParameter(LAST_NAME),
						(String) request.getParameter(EMAIL_ID), null);
				UserDAO.saveUser(user);
				request.setAttribute(MESSAGE,
						"Registration Complete. Please Login");
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("login.jsp");
				dispatcher.forward(request, response);
			}

			else {
				request.setAttribute(MESSAGE, "User Exists");
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("registeration.jsp");
				dispatcher.forward(request, response);
			}
			return;
		}

		// User Controller for login

		String username = request.getParameter(USERNAME);
		String password = request.getParameter(PASSWORD);
		String userLogValue = "false";
		String pageFwd = "";

		User userCheck = UserDAO.getUserByUsername(username);
		HttpSession session = request.getSession();

		if (userCheck != null && !Util.isEmpty(username)
				&& !Util.isEmpty(password)) {
			String enteredUsername = userCheck.getUsername();
			String enteredPassword = userCheck.getPassword();
			password = PasswordUtil.hashPassword(password);
			if (username.equalsIgnoreCase(enteredUsername)
					&& password.equals(enteredPassword)) {

				session.setAttribute(CURRENT_USER, userCheck);
				User currentUser = (User) session.getAttribute(CURRENT_USER);
				userLogValue = (String) session.getAttribute("userLog");
				if (userLogValue == null) {
					pageFwd = "index.jsp";
				}
				else if  (currentUser!=null && "Admin".equalsIgnoreCase(currentUser.getStatus())) { 
					pageFwd = "index.jsp";
				}
				else if (userLogValue.equals("true")) {
					pageFwd = "checkout.jsp";
				}

			} else {
				session.setAttribute(CURRENT_USER, null);
				request.setAttribute(MESSAGE, USERNAME_PASSWORD_INCORRECT);
				pageFwd = "login.jsp";
			}
		} else {
			session.setAttribute(CURRENT_USER, null);
			request.setAttribute(MESSAGE, USERNAME_PASSWORD_INCORRECT);
			pageFwd = "login.jsp";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(pageFwd);
		dispatcher.forward(request, response);

	}
}
