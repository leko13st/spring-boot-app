
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

window.onload = function (){
     var k = document.getElementsByClassName("add-item");
     for(var i = 0; i < k.length; i++){
     	k[i].id = i;
        k[i].onmouseup = function (){
           name = document.querySelectorAll(".car")[this.id].innerText;
        }
     }
}

$(document).ready(function(){
    $(".add-item").on("click", function (e) {
        e.preventDefault();

        $.ajax({
            type: "POST", // HTTP метод  POST или GET
            url: "/rent-auto",// url-адрес, по которому будет отправлен запрос
            dataType:"json", // Тип данных,  которые пришлет сервер в ответ на запрос ,например, HTML, json
            data: {name: name}, //данные, которые будут отправлены на сервер (post переменные)
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