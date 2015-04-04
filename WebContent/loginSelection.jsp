<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>

<head>
<meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
<title>Food On Time</title>
<link rel="shortcut icon" href="favicon.ico" />

</head>

<body onload="changeActiveMenu('login');">

<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="sideBars.jsp"></jsp:include>

<div id="Content">
  <h2> Make Your Choice!!!</h2>
	
	<div style="text-align: center; margin-top: 70px;">
		<a href="login.jsp"><button class="button_tile">Login</button></a>
		<a href="registeration.jsp"><button class="button_tile">Register</button></a>
	</div>
</div>
<div class="spacer">&nbsp;</div>

<jsp:include page="footer.jsp"></jsp:include>
</body>

</html>