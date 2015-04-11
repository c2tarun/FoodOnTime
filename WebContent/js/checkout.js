$(document)
		.ready(
				function() {
					$("#checkoutForm")
							.validate(
									{
										rules : {
											apt : {
												required : true,
												minlength : 2
											},
											streetName : "required",
											city : "required",
											state : "required",
											zipCode : "required",
											cardName : "required",
											expiryDate : "required",
											cardNumber : {
												required : true,
												minlength : 12
											},
											cvv : {
												required : true,
												minlength : 3
											},
										},
										messages : {
											apt : {
												required : "Provide an APT No.",
												minlength : "Provide APT No. which is more than 2 characters long",
											},
											streetName : "Provide a Street Name",
											city : "Provide a City",
											state : "Provide a State",
											zipCode : "Provide a Zip Code",
											cardName : "Provide a Card Name",
											expiryDate : "Provide an Expiry Date",
											cardNumber : {
												required : "Provide a Card Number",
												minlength : "Card Number needs to be 12 characters long"
											},
											cvv : {
												required : "Provide a Cvv",
												minlength : "cvv needs to be 3 characters long"
											},
										}
									});
				});