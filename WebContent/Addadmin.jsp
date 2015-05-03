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

<body >

	<jsp:include page="header.jsp"></jsp:include>
	<jsp:include page="sideBars.jsp"></jsp:include>

	<div id="Content">
		<h2>Admin Add Product</h2>
		<c:if test="${not empty requestScope.Message }">
			<script>alert("${requestScope.Message }");</script>	
			
		</c:if>
		<div class="content-body">
			<form id="addForm" method="post" action="AddProductController">
				<table style="background-color: #F6F6EE;">
					<tr>
						<td style="width: 50%;"><label for="productCode">Product
								Code</label></td>
						<td><input type="text" id="productCode" name="productCode" value="${productCode}"
							maxlength="10" required placeholder="Minimum 4 Characters(PRXX) " /></td>

					</tr>

					<tr>
						<td><label for="productName">Product Name</label></td>
						<td><input type="text" id="productName" name="productName" value="${productName}"
							required placeholder="Product Name" /><br></td>
					</tr>


					<tr>
						<td><label for="category">Category</label></td>
						<td><select name="category" id="category" >
								<option value="bakery" selected>Bakery</option>
								<option value="breakfast">Breakfast</option>
						</select> <br></td>


					</tr>

					<tr>
						<td><label for="description">Product Description</label></td>
						<td>
						<textarea rows="4" cols="29" id="description" name="description"placeholder="Product Description...">${description}</textarea>
						<br></td>
					</tr>





					<tr>
						<td><label>Image URL</label></td>
						<td><input type="text" id="imageUrl" name="imageUrl" value="${imageUrl}"
							size="21" required placeholder="Image URL" /><br></td>
					</tr>



					<tr>
						<td><label>Product Cost</label></td>
						<td><input type="text" id="productCost" name="productCost" value="${productCost}"
							required placeholder="0.00" /><br></td>
					</tr>



					<tr>
						<td colspan="2" style="text-align: center;"><input
							type="submit" value="Add" class="button" /> 

							<a href="ProductsController" class="button"
							style="margin-top: 5px;color:black; ">Cancel</a>

							</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<div class="spacer">&nbsp;</div>
	<jsp:include page="footer.jsp"></jsp:include>


	<script type="text/javascript" src="js/jquery-1.9.0.min.js"></script>
	<script type="text/javascript" src="js/jquery.validate.min.js"></script>
	<script type="text/javascript" src="js/addadmin.js"></script>

</body>
</html>