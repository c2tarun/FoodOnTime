<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>
	 <jsp:include page="sideBars.jsp"></jsp:include>

This is login page 

<div id="Content" >
<form method="Post" action="UserController">
&nbsp;
<h2><b>Login</b></h2>

<center>
<br> 
Username:<br>
<input type="text" name="Username">
<br>
<br>
Passsword:<br>
<input type="text" name="Password">
<br>
<br>
<button value="select">Submit</button>

</center>
</form>
</div>
</body>
</html>