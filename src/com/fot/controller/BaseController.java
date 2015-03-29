package com.fot.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class BaseController extends HttpServlet {

	public static final String PRODUCT_CODE = "ProductCode";
	public static final String PRODUCT = "product";
	public static final String PRODUCT_CATEGORY = "ProductCategory";
	public static final String PRODUCT_LIST = "productList";
	public static final String TOTAL_PRICE = "TotalPrice";
	public static final String CART_LIST = "CartList";
	public static final String DELETE = "delete";
	public static final String DEL_PID = "delPid";
	public static final String SHOPPING_CART = "ShoppingCart";
	public static final String ALL = "All";

	@Override
	protected abstract void doGet(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException;

	@Override
	protected abstract void doPost(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException;
}
