
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

var value = document.querySelectorAll('.car')[0].innerText;

function ready(i){
    document.querySelectorAll(".bucket-input")[i].value = document.querySelectorAll('.car')[i].innerText;
}

document.addEventListener("DOMContentLoaded", ready(0));

jQuery(document).ready(function(){
    jQuery("input").bind("click", function () {
        var name = $(".bucket-input").val(); //post variables

        $.ajax({
            type: "POST", // HTTP метод  POST или GET
            url: "addAuto.php", //url-адрес, по которому будет отправлен запрос
            dataType:"json", // Тип данных,  которые пришлет сервер в ответ на запрос ,например, HTML, json
            data: {name:name}, //данные, которые будут отправлены на сервер (post переменные)
            success:function(response){
            $(".bucket-input").val(''); //очищаем текстовое поле после успешной вставки
            },
            error:function (xhr, ajaxOptions, thrownError){
                alert(thrownError); //выводим ошибку
            }
        });
    });
});