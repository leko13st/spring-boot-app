var id = 0;
var name = "";

window.onload = function (){
     var total_price = 0;
     var k = document.getElementsByClassName("delete-auto");
     for(var i = 0; i < k.length; i++){
        var price = document.querySelectorAll(".price")[i].innerText;
        var count = document.querySelectorAll(".count-auto")[i].value;
        total_price += price * count;
     	k[i].id = i;
        k[i].onmouseup = function (){
           id = this.id;
           name = document.querySelectorAll(".car")[this.id].innerText;
        }
     }

     document.getElementById("total-price").innerText = total_price;
}

$(".count-auto").on('input', function(e){
    $total_price = 0;
    $('.count-auto').each(function(index, el){
        $price = $(".price").eq(index).text();
        $count = $(".count-auto").eq(index).val();
        $total_price += $price * $count;
    });

    $("#total-price").text($total_price);
})

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