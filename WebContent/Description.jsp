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
	<form action="CartController" method="post">
		<jsp:include page="header.jsp"></jsp:include>
		<jsp:include page="sideBars.jsp"></jsp:include>

		<div id="Content1">
			<h2><%=request.getParameter("Name")%></h2>

			<img src="<%=request.getParameter("Logo")%>" width="310" height="300" />
			<div class="item_desc">
				<h1>
					<p>
						<b>Category: </b><%=request.getParameter("Type")%><br> <b>Description:
						</b><%=request.getParameter("Description")%><br> <b>Price: </b>$
						<%=request.getParameter("Price")%><br> <b> Quantity: <select
							id="quantity" name="quantity" style="width: 50px">
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
					</p>
				</h1>
				<input type="hidden" name="quantity" value="quantity" /> <input
					type="hidden" name="pid" value="<%=request.getParameter("PID")%>" />
				<input type="hidden" name="pcost"
					value="<%=request.getParameter("Price")%>" /><br> <br> <input
					type="submit" value="Add To Cart" />


			</div>
		</div>
		<div class="spacer">&nbsp;</div>

		<jsp:include page="footer.jsp"></jsp:include>
	</form>
</body>

</html>