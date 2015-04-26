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
	public static final String PRODUCT_NAME = "productName";
	public static final String CATEGORY = "category";
	public static final String PRODUCT_DESC = "description";
	public static final String IMAGE_URL = "imageUrl";
	public static final String PRODUCT_COST = "productCost";
	public static final String PRODUCT_LIST = "productList";
	public static final String TOTAL_PRICE = "TotalPrice";
	public static final String CART_LIST = "CartList";
	public static final String DELETE = "delete";
	public static final String DEL_PID = "delPid";
	public static final String SHOPPING_CART = "ShoppingCart";
	public static final String ALL = "All";
	public static final String UPDATE_QUANTITY = "UpdateQuantity";
	public static final String UPDATE_PRODUCT = "UpdateProduct";
	public static final String MESSAGE = "Message";	
	public static final String PASSWORD = "password";
	public static final String USERNAME = "username";
	public static final String CURRENT_USER = "currentUser";
	public static final String EMAIL_ID = "emailID";
	public static final String LAST_NAME = "lastName";
	public static final String FIRST_NAME = "firstName";
	public static final String LOGIN_TYPE = "loginType";
	public static final String REGISTRATION = "registration";
	public static final String ORDER_LIST = "orderList";
	
	@Override
	protected abstract void doGet(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException;

	@Override
	protected abstract void doPost(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException;
}
