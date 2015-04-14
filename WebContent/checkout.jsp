<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>

<head>
<meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
<title>Food On Time</title>
<link rel="shortcut icon" href="favicon.ico" />

</head>

<body onload="changeActiveMenu('logout');">

	<jsp:include page="header.jsp"></jsp:include>
	<jsp:include page="sideBars.jsp"></jsp:include>

	<div id="Content">
		<h2>Checkout</h2>


		<div class="content-body">
			<form id="checkoutForm" action="OrderController" method="post">
				<table style="background-color: #F6F6EE;">
					<tr>
						<td><h3>Enter Shipping Details</h3></td>
					</tr>
					<tr>
						<td style="width: 50%;"><label for="apt">Apartment
								No.</label></td>
						<td><input type="text" id="apt" name="apt" maxlength="10"
							required placeholder="Your Apartment No." /></td>

					</tr>

					<tr>
						<td><label for="streetName">Street Name</label></td>
						<td><input type="text" id="streetName" name="streetName"
							required placeholder="Your street Name" /><br></td>
					</tr>



					<tr>
						<td><label for="city">City</label></td>
						<td><input type="text" id="city" name="city" required
							placeholder="Your city" /><br></td>
					</tr>



					<tr>
						<td><label for="state">State</label></td>
						<td><input type="text" id="state" name="state" size="21"
							required placeholder="Your State" /><br></td>
					</tr>


					<tr>
						<td><label>Zip Code</label></td>
						<td><input type="text" id="zipCode" name="zipCode" maxlength="5"  size="21"
							required placeholder="Your zip code" /><br></td>
					</tr>
					<tr>
						<td><h3>Enter Card Details</h3></td>
					</tr>
					<tr>
						<td><label for="cardName">Name on Card</label></td>
						<td><input type="text" id="cardName" name="cardName" required
							placeholder="Your card name" /><br></td>
					</tr>



					<tr>
						<td><label for="cardNumber">Card Number</label></td>
						<td><input type="text" id="cardNumber" name="cardNumber"
							maxlength="12" required placeholder="Your card number" /><br></td>
					</tr>
					<tr>
						<td><label for="expiryDate">Expiry date</label></td>
						<td><input type="date" id="expiryDate" name="expiryDate"
							required /><br></td>
					</tr>



					<tr>
						<td><label for="cvv">CVV</label></td>
						<td><input type="text" id="cvv" name="cvv" maxlength="3"
							required placeholder="Your cvv" /><br></td>
					</tr>
					<tr>
						<td colspan="2" style="text-align: center;"><input
							type="submit" value="SUBMIT" class="button" /> <input
							type="reset" value="RESET" class="button" /></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<div class="spacer">&nbsp;</div>
	<jsp:include page="footer.jsp"></jsp:include>


	<script type="text/javascript" src="js/jquery-1.9.0.min.js"></script>
	<script type="text/javascript" src="js/jquery.validate.min.js"></script>
	<script type="text/javascript" src="js/checkout.js"></script>

</body>
</html>