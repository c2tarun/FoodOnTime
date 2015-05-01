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

<body onload="changeActiveMenu('Admin');">
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="sideBars.jsp"></jsp:include>
<div id="Content">
  <h2> Current Orders </h2>
  	<div class="content-body">
	<c:if test="${empty requestScope.orderList }">
		<center>
			<h1>No Orders Right Now</h1>
		</center>
	</c:if>
	
	<c:if test="${fn:length(requestScope.orderList)>0 }">
	<table style="background-color: #F6F6EE; border-collapse: collapse; width: 102%;margin-left:-2%;" border="1">
		<tr><th>Products</th><th>Address</th><th>Delivery Date</th><th>Cost($)</th><th></th></tr>
	    <c:forEach var="orders" items="${requestScope.orderList}" varStatus="orderCount">
	    	<tr><td>${orders.products }</td><td>${orders.address }</td>
	    	<td>${orders.deliveryDate }</td><td>${orders.totalCost }</td>
	    	<td><form method="post" action="OrderController?action=AcceptOrder">
	    			<input type="hidden" value="${orders.orderId }" name="acceptOrderId" />
	    			<input type="submit" value="Dispatch" />
	    		</form>
	    	</td></tr>
	    </c:forEach>
    </table>	
    </c:if>
    </div>
	<h1>&nbsp;</h1>
</div>
<div class="spacer">&nbsp;</div>

<jsp:include page="footer.jsp"></jsp:include>
</body>

</html>