
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


function inputChange(){
    var filter = document.getElementById('input-filter');
    let str = filter.value.toLowerCase();
    let tables = document.querySelectorAll('.table');

    for (let i = 0; i < tables.length; i++){
        var car = document.querySelectorAll('.car')[i].innerText.toLowerCase();
        if (car.indexOf(str) == -1)
            tables[i].style.display = "none";
        else
            tables[i].style.display = "table";
    }
}