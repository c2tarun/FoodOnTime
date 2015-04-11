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
<style>
table, th, td {
	text-align: center;
	border: 1px solid black;
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
<b>Shipping address</b><br/>
${sessionScope.currentUser} <br/>
	Apt		${sessionScope.apt} , ${sessionScope.streetName}<br/>
			${sessionScope.city}, ${sessionScope.state}<br/>
			${sessionScope.zipCode}<br/>
		
			<h2>Order Summary</h2>
			<table border="1">
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
		</div>
	</div>
	<div class="spacer">&nbsp;</div>
	<jsp:include page="footer.jsp"></jsp:include>



</body>
</html>