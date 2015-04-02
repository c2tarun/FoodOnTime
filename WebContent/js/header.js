function changeActiveMenu(menuName){
	var d = document.getElementById(menuName);
	d.className = "active";
}

function clearList(){
	System.out.println("This is from js " + document.getElementById("select_product").value);
	
	document.getElementById("viewProductList").innerHTML="";
}

function addToCart(count){
	document.getElementById("addToCartForm"+count).submit();
}

function updateQuantityFunction(count){
	document.getElementById("form"+count).submit();
}

