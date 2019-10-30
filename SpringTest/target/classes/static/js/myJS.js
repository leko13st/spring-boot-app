function sum(){
	var chbox = document.getElementById('cb');
	if (chbox.checked){
		document.getElementById('result').InnerHTML = document.getElementById('price') + 3000;
	}
	else{
		document.getElementById('result').InnerHTML = document.getElementById('price');
	}
}