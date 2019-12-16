
function changeCity(){
    var city = select_city.city.options.selectedIndex;
    document.cookie = "city=" + city + "; path=/rent-auto;"
}

function readCookie(name) {
	var name_cook = name+"=";
	var spl = document.cookie.split(";");

	for(var i=0; i<spl.length; i++) {
		var c = spl[i];

		while(c.charAt(0) == " ") {
			c = c.substring(1, c.length);
		}

		if(c.indexOf(name_cook) == 0) {
			return c.substring(name_cook.length, c.length);
		}
	}
	return null;
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

var name = "";
var price = 0;

window.onload = function (){
     select_city.city.options.selectedIndex = readCookie("city");
     var k = document.getElementsByClassName("add-item");
     for(var i = 0; i < k.length; i++){
     	k[i].id = i;
        k[i].onmouseup = function (){
           name = document.querySelectorAll(".car")[this.id].innerText;
           price = document.querySelectorAll(".price")[this.id].innerText;
        }
        k[i].onclick = function (){
            this.disabled = true;
        }
     }
}

$(document).ready(function(){
    jQuery.getJSON('/passive-button-index', function(data){
    var arr = data.indexes;
        $('.car').each(function(index, el){
            var button = $(".add-item")[index];
            if ($.inArray($(el).text(), arr) != -1)
                button.disabled = true;
        });
    });

    $(".add-item").on("click", function (e) {
        e.preventDefault();

        $.ajax({
            type: "POST", // HTTP метод  POST или GET
            url: "/rent-auto",// url-адрес, по которому будет отправлен запрос
            dataType:"json", // Тип данных,  которые пришлет сервер в ответ на запрос ,например, HTML, json
            data: {name: name, price: price}, //данные, которые будут отправлены на сервер (post переменные)
            success:function(response){
                alert("Товар: " + name + " добавлен в корзину!");
                jQuery.getJSON('/get-cart-count', function(data){
                $('#item-count').text(data.count);
                });
            },
            error:function (xhr, ajaxOptions, thrownError){
                alert(thrownError); //выводим ошибку
            }
        });
    });
});

$(document).ready(function(){
    jQuery.getJSON('/get-cart-count', function(data){
        $('#item-count').text(data.count);
        });
});