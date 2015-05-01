<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/button.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="js/jquery-1.9.0.min.js"></script>
<script type="text/javascript" src="js/header.js"></script>
<script type="text/javascript" src="js/validate_number.js"></script>

</head>
<body>
	<div id="Header">
		<ul id="navigation">
			<li id="index"><a href="index.jsp">Home</a></li>
			<li id="menu1"><a href="ProductsController">Menu</a></li>
			
			<c:if test="${currentUser eq null}">
				<li id="login"><a href="loginSelection.jsp">Login</a></li>
			</c:if>
			
			<c:if test="${currentUser.status eq 'admin'}">
				<li id="Admin"><a href="OrderController?page=Admin">Orders</a></li>
			</c:if>
			
			<c:if test="${currentUser ne null}">
				<c:if test="${currentUser.status ne 'admin' }">
					<li id="Cancel"><a href = "OrderController?page=Cancel">Cancel</a></li>
					<li id="History"><a href = "OrderController?page=History">My Order</a></li>
            	</c:if>
            	<li id="logout"><a href="logout.jsp">Logout</a></li>
            </c:if>

		</ul>
		<c:if test="${currentUser.status ne 'admin'}">
		<div class="image">
			<a href="Cart.jsp"><img src="images/cart.png" width="30"
				height="30" /> <span> <c:if
						test="${ShoppingCart.numberOfItems ge 0}">
						<b>${ShoppingCart.numberOfItems} items</b>
					</c:if> <c:if test="${empty ShoppingCart}">
						<b>0 items</b>
					</c:if>
			</span></a>
		</div></c:if>
	</div>
	<div id="header2">
		<div class="logo">Food On Time</div>
		<div class="banner">
			<c:if test="${currentUser eq null}">
				<span>Hello, Guest</span>
			</c:if>
			<c:if test="${currentUser ne null}">
				<span>Hello, ${currentUser.firstName}</span>
			</c:if>
		</div>
	</div>
</body>
</html>