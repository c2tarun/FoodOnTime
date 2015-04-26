<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.fot.dao.ProductDAO"%>

<%@ page import="java.util.ArrayList"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>
<meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
<title>Food On Time</title>
<link rel="shortcut icon" href="favicon.ico" />

<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/header.js"></script>
</head>

<body onload="changeActiveMenu('menu1');">

	<jsp:include page="header.jsp"></jsp:include>
	<jsp:include page="sideBars.jsp"></jsp:include>

	<div id="Content">
		<h2>Select Your Menu!!!!</h2>
		<div class="content-body">
			<h1 style="display: inline-block">Filter By Category</h1>

			<c:set var="stat" scope="session" value="admin" />
			<c:if test="${currentUser.status eq stat}">
				<a href="Addadmin.jsp" class="button"
					style="margin-top: 20px; float: right;">Add Product</a>

			</c:if>


			<form name='test'>
				<select id="select_product" style="margin-left: 10px;"
					name="ProductCategory"><option>All</option>
					<option>bakery</option>
					<option>breakfast</option>
				</select> <a href="ProductsController"><button id="submitCategory"
						onclick="clearList()" value="select">Submit</button></a>

			</form>
			<br />
			<div id="viewProductList">


				<c:forEach var="products" items="${requestScope.productList}"
					varStatus="productCount">
					<div class="menu-item">
						<div class="top_desc">
							<b>${products.productName }</b>
						</div>

						<a href="ProductsController?productCode=${products.productCode}"
							id="logo"><img src="${products.imageUrl }" width="110"
							height="100" /></a>

						<div class="bottom_desc">
							<p style="display: inline-block; font-size: 18px;">
								<b>Price : $ ${products.productCost }</b>
							</p>
							<form style="display: inline-block; float: right" method="get"
								action="CartController" id="addToCartForm${productCount.count }">
								<input type="hidden" style="display: inline-block; float: right"
									name="productCode" id="productCode"
									value="${products.productCode }" />
								<c:if test="${currentUser.status ne 'admin'}">
									<a href="#" style="float: right;"
										onClick="addToCart(${productCount.count})"> <img
										src="images/cart.png" width="20" height="20" /></a>
									<input type="hidden" name="ProductCategory"
										value="${ProductCategory}" />
								</c:if>


							</form>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
	<div class="spacer">&nbsp;</div>

	<jsp:include page="footer.jsp"></jsp:include>

</body>

</html>