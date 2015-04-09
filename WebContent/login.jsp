<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link href="css/style.css" rel="stylesheet" type="text/css" />

<title>Login Page</title>
</head>
<body onload="changeActiveMenu('login');">

<jsp:include page="header.jsp"></jsp:include>
	 <jsp:include page="sideBars.jsp"></jsp:include>
	 
<div id="Content" >

<form method="Post" action="UserController" id="myForm">

&nbsp;
<h2><b>Login</b></h2>

<c:if test="${not empty requestScope.Message }">
	<script>alert("${requestScope.Message }");</script>
</c:if>

<center>
<br> 
Username:<br>
<input type="text" name="Username">
<br>
<br>
Password:<br>
<input type="text" name="Password">
<br>
<br>
<button value="select">Submit</button>



</center>
</form>
</div>
</body>
</html>
