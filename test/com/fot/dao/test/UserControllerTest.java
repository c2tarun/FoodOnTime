package com.fot.dao.test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Matchers.eq;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Test;

import com.fot.controller.BaseController;
import com.fot.controller.UserController;
import com.fot.dao.ProductDAO;
import com.fot.dao.UserDAO;
import com.fot.model.User;

public class UserControllerTest {

	@Test
	public void doPostUserRegistrationNegativeTest() {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		RequestDispatcher dispatcher = mock(RequestDispatcher.class);

		when(request.getParameter(BaseController.LOGIN_TYPE)).thenReturn(
				BaseController.REGISTRATION);
		when(request.getParameter(BaseController.USERNAME)).thenReturn(
				"c2tarun");
		when(request.getRequestDispatcher("login.jsp")).thenReturn(dispatcher);
		when(request.getRequestDispatcher("registeration.jsp")).thenReturn(
				dispatcher);

		try {
			new UserController().doPost(request, response);
			verify(request).setAttribute(BaseController.MESSAGE, "User Exists");
			verify(dispatcher).forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void doPostUserRegistrationTest() {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		RequestDispatcher dispatcher = mock(RequestDispatcher.class);

		when(request.getParameter(BaseController.LOGIN_TYPE)).thenReturn(
				BaseController.REGISTRATION);
		when(request.getParameter(BaseController.USERNAME)).thenReturn(
				"testReg");
		when(request.getParameter(BaseController.PASSWORD)).thenReturn(
				"password");
		when(request.getParameter(BaseController.FIRST_NAME)).thenReturn(
				"testReg");
		when(request.getParameter(BaseController.LAST_NAME)).thenReturn(
				"testReg");
		when(request.getParameter(BaseController.EMAIL_ID)).thenReturn(
				"testReg@gmail.com");
		when(request.getRequestDispatcher("login.jsp")).thenReturn(dispatcher);
		when(request.getRequestDispatcher("registeration.jsp")).thenReturn(
				dispatcher);

		try {
			new UserController().doPost(request, response);
			verify(request).setAttribute(BaseController.MESSAGE,
					"Registration Complete. Please Login");
			verify(dispatcher).forward(request, response);

			UserDAO.deleteUserByUsername("testReg");
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void doPostUserLoginTest() {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		RequestDispatcher dispatcher = mock(RequestDispatcher.class);
		HttpSession session = mock(HttpSession.class);

		when(request.getSession()).thenReturn(session);
		when(request.getParameter(BaseController.LOGIN_TYPE)).thenReturn(null);
		when(request.getParameter(BaseController.USERNAME)).thenReturn(
				"c2tarun");
		when(request.getParameter(BaseController.PASSWORD)).thenReturn(
				"password");
		when(request.getRequestDispatcher("index.jsp")).thenReturn(dispatcher);
		when(request.getRequestDispatcher("checkout.jsp")).thenReturn(dispatcher);
		when(request.getRequestDispatcher("login.jsp")).thenReturn(dispatcher);
		
		try {
			new UserController().doPost(request, response);
			User user = new User();
			user.setUsername("c2tarun");
			verify(session).setAttribute(BaseController.CURRENT_USER, user);
			verify(dispatcher).forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void doPostUserLoginNegativeTest() {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		RequestDispatcher dispatcher = mock(RequestDispatcher.class);
		HttpSession session = mock(HttpSession.class);

		when(request.getSession()).thenReturn(session);
		when(request.getParameter(BaseController.LOGIN_TYPE)).thenReturn(null);
		when(request.getParameter(BaseController.USERNAME)).thenReturn(
				"c2tarun");
		when(request.getParameter(BaseController.PASSWORD)).thenReturn(
				"password12");
		when(request.getRequestDispatcher("index.jsp")).thenReturn(dispatcher);
		when(request.getRequestDispatcher("checkout.jsp")).thenReturn(dispatcher);
		when(request.getRequestDispatcher("login.jsp")).thenReturn(dispatcher);
		
		try {
			new UserController().doPost(request, response);
			User user = new User();
			user.setUsername("c2tarun");
			verify(session).setAttribute(BaseController.CURRENT_USER, null);
			verify(request).setAttribute(BaseController.MESSAGE, "Username password incorrect.");
			verify(dispatcher).forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

}
