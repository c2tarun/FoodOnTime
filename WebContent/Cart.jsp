<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.fot.dao.ProductDAO"%>



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
		<h2>Cart</h2>
		<div class="content-body">
			<table border="1" style="width: 100%; text-align: center;">
				<thead>
					<tr>
						<th>ProductName</th>
						<th>Quantity</th>
						<th>ProductCost</th>
						<th>Delete</th>
					</tr>
				</thead>
				<tbody>


					<c:forEach var="products" items="${sessionScope.CartList}">
						<tr>
							<td>${products.product.productName }</td>
							<td>${products.quantity }</td>
							<td>$ ${products.quantity * products.product.productCost }</td>
							<td><form action="CartController" method="post">
									<input type="hidden" name="delete" value="true" /> <input
										type="hidden" name="delPid"
										value="${products.product.productCode}" /> <input
										id="deleteCartProduct" type="submit" value="Delete"
										style="margin-top: 20px;" />
								</form></td>
						</tr>
					</c:forEach>

					<tr>
						<td></td>
						<td></td>
						<td><b>Total Price:$ ${sessionScope.TotalPrice}</b></td>
						<td></td>
					</tr>
				</tbody>
			</table>

		</div>
	</div>
	<div class="spacer">&nbsp;</div>

	<jsp:include page="footer.jsp"></jsp:include>

</body>

</html>