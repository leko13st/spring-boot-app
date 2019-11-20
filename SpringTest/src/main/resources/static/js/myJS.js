
var result = document.getElementById('result');
var price = document.getElementById('price');

function statePrice(){
    result.innerHTML = Number(price.innerHTML);
}

function sum(){
	var chbox = document.getElementById('cb');

	if (chbox.checked){
		result.innerHTML = Number(price.innerHTML) + 3000;
	}
	else{
		result.innerHTML = Number(price.innerHTML);
	}
}