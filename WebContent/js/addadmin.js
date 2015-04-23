$(document)
		.ready(
				function() {

					$("#addForm")
							.validate(
									{
										rules : {
											productCode : {
												required : true,
												minlength : 3
											},
											productName : "required",
											category : "required",
											description : "required",
											imageUrl : "required",
											productCost : "required",
										},
										messages : {
											productCode : {
												required : "Provide a Product Code",
											},
											productName : "Provide a Product Name",
											category : "Provide a Category",
											description : "Provide a Description",
											imageUrl : "Provide a Image URL",
											productCost : "Provide Product Cost",
										}
									});
				});