function getDate(){
	var d = new Date();

	var month = d.getMonth()+1;
	var day = d.getDate();

	var output = d.getFullYear() + '/' +
	    (month<10 ? '0' : '') + month + '/' +
	    (day<10 ? '0' : '') + day;
	
	$("#orderDate").val(output);
}

function validateDate(){
		
		var d=new Date();
		var month = ((d.getMonth()+1)>9)?(d.getMonth()+1):"0"+(d.getMonth()+1);
		var day = ((d.getDate())>9)?(d.getDate()):"0"+(d.getDate());
		
		$("#deliveryDate").prop("min",d.getFullYear()+"-"+month+"-"+day);
		
		d.setDate(d.getDate()+7);
		var max_month = ((d.getMonth()+1)>9)?(d.getMonth()+1):"0"+(d.getMonth()+1);
		var max_day = ((d.getDate())>9)?(d.getDate()):"0"+(d.getDate());
		
		$("#deliveryDate").prop("max",d.getFullYear()+"-"+max_month+"-"+max_day);	
		
		var expiry_day = "01";
		var expiry_month = ((d.getMonth()+1)>=5)?"01":"06";
		var expiry_year = ((d.getMonth()+1)>=5)?d.getFullYear()+1:d.getFullYear();
		$("#expiryDate").prop("min",expiry_year+"-"+expiry_month+"-"+expiry_day);
}

function checkDate(){
	var d = new Date();
	d.setDate(d.getDate()+7);
	var month = ((d.getMonth()+1)>9)?(d.getMonth()+1):"0"+(d.getMonth()+1);
	var day = ((d.getDate())>9)?(d.getDate()):"0"+(d.getDate());
	
	if($("#deliveryDate").val()>d.getFullYear()+"-"+month+"-"+day)
		$("#deliveryDate").val("");
}

function checkExpiry(){
	
	var expiry_day = "01";
	var expiry_month = ((d.getMonth()+1)>=5)?"01":"06";
	var expiry_year = ((d.getMonth()+1)>=5)?d.getFullYear()+1:d.getFullYear();
	
	if($("#expiryDate").val()<expiry_year+"-"+expiry_month+"-"+expiry_day)
		$("#expiryDate").val("");
}

function validateTime(){
	var date=new Date();
	
	if(($("#deliveryTime").val().split(" ")[0]>"23:00") || ($("#deliveryTime").val().split(" ")[0]<"06:00"))
		$("#deliveryTime").val("");	
	
	else if($("#deliveryDate").val()){
		
		if($("#deliveryDate").val().split("-")[2] == date.getDate() &&
				($("#deliveryTime").val().split(":")[0]<date.getHours() || $("#deliveryTime").val().split(" ")[0]<((date.getHours()+1)+":"+date.getMinutes())))
					$("#deliveryTime").val("");	
	}

	
}

function clearTime(){
	$("#deliveryTime").val("");
}