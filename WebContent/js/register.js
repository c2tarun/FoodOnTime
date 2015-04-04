$(document)
		.ready(
				function() {

					$("#myForm")
							.validate(
									{
										rules : {
											userName : {
												required : true,
												minlength : 4
											},
											firstName : "required",
											lastName : "required",
											emailID : {
												required : true,
												email : true
											},
											password : {
												required : true,
												minlength : 6
											},
											confirmPassword : {
												required : true,
												equalTo : "#password"
											},
										},
										messages : {
											userName : {
												required : "Provide an User Name",
												minlength : "Select an Username which is 4 characters long",
											},
											firstName : "Provide a First Name",
											lastName : "Provide a Last Name",
											emailID : {
												required : "We need your email address to contact you",
												email : "Your email address must be in the format of name@domain.com"
											},
											password : {
												required : "Provide a password which is 6 character in length",
												minlength : "Password needs to be 6 characters long"
											},
											confirmPassword : {
												equalTo : "Both the Passwords must match"
											},
										}
									});
				});