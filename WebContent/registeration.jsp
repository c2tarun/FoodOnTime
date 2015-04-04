<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>

<head>
<meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
<title>Food On Time</title>
<link rel="shortcut icon" href="favicon.ico" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>

<body onload="changeActiveMenu('menu1');">

	<jsp:include page="header.jsp"></jsp:include>
	<jsp:include page="sideBars.jsp"></jsp:include>

	<div id="Content">
		<h2>USER REGISTERATION</h2>
		<div class="content-body">
			<form id="myForm">
				<table style="background-color: #F6F6EE;">
					<tr>
						<td><label for="userName">UserName</label></td>
						<td><input type="text" id="userName" name="userName"
							maxlength="6" /></td>

					</tr>

					<tr>
						<td><label for="first_name">FirstName</label></td>
						<td><input type="text" id="first_name" name="firstName" /><br></td>
					</tr>



					<tr>
						<td><label for="last_name">LastName</label></td>
						<td><input type="text" id="last_name" name="lastName" /><br></td>
					</tr>



					<tr>
						<td><label for="password">Password</label></td>
						<td><input type="password" id="password" name="password"
							size="21" /><br></td>
					</tr>


					<tr>
						<td><label>ConfirmPassword</label></td>
						<td><input type="password" id="confirm_password"
							name="confirmPassword" size="21" /><br></td>
					</tr>



					<tr>
						<td><label>Email</label></td>
						<td><input type="email" id="email_id" name="emailID" /><br></td>
					</tr>



					<!-- <input type="submit" value="SUBMIT" onclick="return confirm('Are you sure?')" onclick="javascript:validate_textbox1(this.form); /> -->
					<tr>
						<td><input type="submit" value="SUBMIT" /> <input
							type="reset" value="RESET"></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<div class="spacer">&nbsp;</div>
	<jsp:include page="footer.jsp"></jsp:include>


	<script type="text/javascript" src="js/jquery-1.9.0.min.js"></script>
	<script type="text/javascript" src="js/jquery.validate.min.js"></script>
	<script type="text/javascript" src="js/register.js"></script>

</body>
</html>