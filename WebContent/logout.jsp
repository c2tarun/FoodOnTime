<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Logout</title>
</head>
<body>

 <%=session.getAttribute("currentUser")
%>
<%
session.removeAttribute("currentUser");
session.removeAttribute("ShoppingCart");
session.removeAttribute("CartList");
session.removeAttribute("TotalPrice");
session.removeAttribute("userLog");
%>

<%
response.sendRedirect("index.jsp");
%>

</body>
</html>


