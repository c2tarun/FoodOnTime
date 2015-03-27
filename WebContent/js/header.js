function changeActiveMenu(menuName){
	var d = document.getElementById(menuName);
	d.className = "active";
}

function clearList(){
	document.getElementById("viewProductList").innerHTML="";
}

function addToCart(count){
	document.getElementById("addToCartForm"+count).submit();
}
