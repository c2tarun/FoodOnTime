<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.fot.dao.ProductDAO"%>



<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>
<meta http-equiv="content-type"  content="text/html; charset=iso-8859-1" />
<title>Food On Time</title>
<link rel="shortcut icon" href="favicon.ico" />

<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/button.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/header.js"></script>
</head>

<body onload="changeActiveMenu('menu1');">
	<jsp:include page="header.jsp"></jsp:include>
	<jsp:include page="sideBars.jsp"></jsp:include>

	<div id="Content1">
		<center><h2>${product.productName }</h2></center><br/>

		<img src="${product.imageUrl}" width="310" height="300" />
		<div class="item_desc">
			<h1>
				<p>
					<b>Category: </b>${product.category}<br> <b>Description:
					</b>${product.description}<br> <b>Price: </b>$
					${product.productCost}<br>
				</p>
			</h1>


			<a href="CartController?productCode=${product.productCode }" class="button">Add To Cart</a>


		</div>
		<div class="spacer">&nbsp;</div>

		<jsp:include page="footer.jsp"></jsp:include>
	</form>
</body>

</html>