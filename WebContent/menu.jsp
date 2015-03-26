<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.fot.dao.ProductDAO"%>
	


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
		<h2>Select Your Menu!!!</h2>
		<div class="content-body">
			<h1>
				Filter By <select><option>---</option>
					<option>Beverages</option></select>
			</h1>

			
			
			
			
			<c:forEach var = "products" items = "${requestScope.productList}">
				<div class="menu-item">
					<div class="top_desc">
						<b>${products.productName }</b>
					</div>
					<a href="Description.jsp?Description=${products.description} &Name=${products.productName} &Logo=${products.imageUrl} &Price=${products.productCost} &Type=${products.category} &Code=${products.productCode}" id="logo"><img src="${products.imageUrl }" width="110" height="100" /></a>
					<div class="bottom_desc">
					<p style="display:inline-block; font-size: 18px;"><b>Price : $ ${products.productCost }</b></p><a href="#" style="float: right;"><img src="images/cart.png" width="20" height="20"
						 /></a>
					</div>
				</div>
			</c:forEach>
			
			
		</div>
	</div>
	<div class="spacer">&nbsp;</div>
	
	<jsp:include page="footer.jsp"></jsp:include>
	
</body>

</html>