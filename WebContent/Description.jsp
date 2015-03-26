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

	<div id="Content1">
		<h2><%=request.getParameter("Name")%></h2>

		<img src="<%=request.getParameter("Logo")%>" width="310" height="300" />
		<div class="item_desc">
			<h1>
				<p>
					<b>Category: </b><%=request.getParameter("Type")%><br> <b>Description:
					</b><%=request.getParameter("Description")%><br> <b>Price: </b>$
					<%=request.getParameter("Price")%><br>
				</p>
			</h1>

			<input type="submit" value="Add To Cart" />


		</div>
	</div>
	<div class="spacer">&nbsp;</div>

	<jsp:include page="footer.jsp"></jsp:include>

</body>

</html>