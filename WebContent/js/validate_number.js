/**
 * 
 */
$(document).ready(function(){
$("#cvv,#cardNumber,#zipCode,#productCost").on("keypress",function(evt){
	
	evt = (evt) ? evt : window.event;
    var charCode = (evt.which) ? evt.which : evt.keyCode;
    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
        return false;
    }
    return true;
});

$("#streetName,#city,#state,#cardName").on("keypress",function(evt){
	
	evt = (evt) ? evt : window.event;
    var charCode = (evt.which) ? evt.which : evt.keyCode;
    if ((charCode > 64 && charCode <91) || (charCode > 96 && charCode < 123)) {
        return true;
    }
    return false;
});
});