package com.fot.dao.test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;

import com.fot.controller.BaseController;
import com.fot.controller.ProductsController;

public class ProductControllerTest {

	@Test
	public void doGetProductCategoryTest() {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		RequestDispatcher dispatcher = mock(RequestDispatcher.class);

		when(request.getParameter(BaseController.PRODUCT_CATEGORY)).thenReturn(
				"bakery");
		when(request.getRequestDispatcher("menu.jsp")).thenReturn(dispatcher);
		try {
			new ProductsController().doGet(request, response);
			verify(request).setAttribute(BaseController.PRODUCT_CATEGORY, "bakery");
			verify(dispatcher).forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//TODO: Try to test whether request has product list or not
		//verify(request).setAttribute();
	}
	
	@Test
	public void doGetAllProductTest() {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		RequestDispatcher dispatcher = mock(RequestDispatcher.class);

		when(request.getParameter(BaseController.PRODUCT_CODE)).thenReturn(null);
		when(request.getParameter(BaseController.PRODUCT_CATEGORY)).thenReturn(null);
		when(request.getRequestDispatcher("menu.jsp")).thenReturn(dispatcher);
		
		try {
			new ProductsController().doGet(request, response);
			verify(dispatcher).forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
