$(document).ready(function() {
	$("#checkoutForm").validate({
		rules : {
			apt : {
				required : true,
				minlength : 2
			},
			streetName : "required",
			city : "required",
			state : "required",
			zipCode : {
				required:true,
				minlength: 5
			},
			addr1 : "required",
			billCity : "required",
			billState : "required",
			billZip : {
				required:true,
				minlength: 5
			},
			cardName : "required",
			expiryDate : "required",
			cardNumber : {
				required : true,
				minlength : 16
			},
			cvv : {
				required : true,
				minlength : 3
			},
			deliveryTime : "required"
		},
		messages : {
			apt : {
				required : "Provide an APT No.",
				minlength : "Provide APT No. which is more than 2 characters long",
			},
			streetName : "Provide a Street Name",
			city : "Provide a City",
			state : "Provide a State",
			zipCode : {
				required: "Provide a Zip Code",
				minlength: "Zip Code must contain 5 digits"
			},
			addr1 : "Provide an Address",
			billCity :  "Provide a City",
			billState : "Provide a State",
			billZip : {
				required:"Provide a Zip Code",
				minlength: "Zip Code must contain 5 digits"
			},
			cardName : "Provide a Card Name",
			expiryDate : "Provide an Expiry Date",
			cardNumber : {
				required : "Provide a Card Number",
				minlength : "Card Number needs to be 16 characters long"
			},
			cvv : {
				required : "Provide a Cvv",
				minlength : "cvv needs to be 3 characters long"
			},
			deliveryTime : "Please provide the Time"
		}
	});
});