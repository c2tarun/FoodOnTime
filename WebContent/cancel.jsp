<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>

<head>
<meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
<title>Food On Time</title>
<link rel="shortcut icon" href="favicon.ico" />

</head>

<body onload="changeActiveMenu('History');">
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="sideBars.jsp"></jsp:include>
<div id="Content">
  <h2> My Purchase History </h2>
	<c:if test="${empty sessionScope.orderList }">
		<center>
			<h1>No Recent Orders Found To Cancel</h1>
		</center>
	</c:if>
	
	<c:if test="${fn:length(sessionScope.orderList)>0 }">
	<table style="background-color: #F6F6EE; border-collapse: collapse;" border="1">
		<tr><th>Order Date</th><th>Products</th><th>Delivery Date</th><th>Total Cost($)</th><th>Cancel</th></tr>
	    <c:forEach var="orders" items="${requestScope.orderList}" varStatus="orderCount">
	    	<tr><td>${orders.orderDate }</td><td>${orders.products }</td>
	    	<td>${orders.deliveryDate }</td><td>${orders.totalCost }</td><td><button>Cancel</button></td></tr>
	    </c:forEach>
    </table>	
    </c:if>
	<h1>&nbsp;</h1>
</div>
<div class="spacer">&nbsp;</div>

<jsp:include page="footer.jsp"></jsp:include>
</body>

</html>