var id = 0;
var name = "";

window.onload = function (){
     var k = document.getElementsByClassName("delete-auto");
     for(var i = 0; i < k.length; i++){
     	k[i].id = i;
        k[i].onmouseup = function (){
           id = this.id;
           name = document.querySelectorAll(".car")[this.id].innerText;
        }
     }
}

$(document).ready(function(){
    $(".delete-auto").on("click", function (e) {
        e.preventDefault();

        $.ajax({
            type: "POST", // HTTP метод  POST или GET
            url: "/delete-cart-auto",// url-адрес, по которому будет отправлен запрос
            dataType:"json", // Тип данных,  которые пришлет сервер в ответ на запрос ,например, HTML, json
            data: {id: id}, //данные, которые будут отправлены на сервер (post переменные)
            success:function(response){
                alert("Авто " + name + " удалена из корзины");
                location.reload(true);
            },
            error:function (xhr, ajaxOptions, thrownError){
                alert(thrownError); //выводим ошибку
            }
        });
    });
});