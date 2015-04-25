<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>

<head>
<meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
<title>Food On Time</title>
<link rel="shortcut icon" href="favicon.ico" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/button.css" rel="stylesheet" type="text/css" />
<style>
table, th, td {
	border-collapse: collapse;
}
</style>
</head>

<body onload="changeActiveMenu('login');">

	<jsp:include page="header.jsp"></jsp:include>
	<jsp:include page="sideBars.jsp"></jsp:include>

	<div id="Content">
		<h2>Order Placed</h2>


		<div class="content-body">
		<h2>Thank You for Placing the order</h2>
		<table border="0"><tr><td>

<b>Shipping address</b><br/>
${sessionScope.currentUser.username} <br/>
	Apt		${sessionScope.apt} , ${sessionScope.streetName}<br/>
			${sessionScope.city}, ${sessionScope.state}<br/>
			${sessionScope.zipCode}<br/>
		</td>
		<td>
		<span  style="float: right;">
		<b>Shipping Date & Time</b><br/>
		<c:set var = "date" value="${fn:split(sessionScope.deliveryTime,'T')[0] }"></c:set>
		<c:set var = "time" value="${fn:split(sessionScope.deliveryTime,'T')[1] }"></c:set>
		${date }&nbsp; ${time}
		</span>	
		</td></tr></table>
			<h2>Order Summary</h2>
			<table border="1" style="text-align: center;
	border: 1px solid black;
	border-collapse: collapse;">
				<thead>

					<tr>
						<th>ProductName</th>
						<th>ProductCost</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="products" items="${sessionScope.CartList}"
						varStatus="cartCount">
						<tr>
							<td>${products.product.productName }</td>
							<td>$ ${products.quantity * products.product.productCost}</td>
						</tr>
					</c:forEach>

					<tr>
						<td><b>Total Price:</b></td>
						<td><b>$ ${sessionScope.TotalPrice}</b></td>

					</tr>
				</tbody>
			</table>
			<br/>
			<center>
				<button onclick="window.location='ProductsController'" class="button">Order More</button>
				<button onclick="window.location='logout.jsp'" class="button">Exit Now</button>
			</center>
		</div>
	</div>
	<div class="spacer">&nbsp;</div>
	<jsp:include page="footer.jsp"></jsp:include>



</body>
</html>