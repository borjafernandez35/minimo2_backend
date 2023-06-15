verificarSesion();
function redirigirALoginT() {
    if (window.location.pathname !== "/Login.html") {
        window.location.href = "Login.html";
    }
}
function verificarSesion() {
    var token = localStorage.getItem('token');
    if (!token) {
        redirigirALoginT();
        return;
    }
    else {
        return;
    }
}
function listadeObjetos() {
    var token = localStorage.getItem('token');
    if (!token) {
        redirigirALoginT();
        return;
    }
    $("#tcuerpo").empty();
    $.ajax({
        type: 'GET',
        url: "/dsaApp/game/listaObjetos",
        dataType: 'json',
        success: function (result) {
            for (let i = 0; i < result.length; i++) {
                console.log("i: " + i, result[i]);
                $("#tabla").append(
                    "<tr> <td>" + result[i].nombre +
                    "</td> <td>" + result[i].descripcion +
                    "</td> <td>" + result[i].precio + "</td>" +
                    '</td><td>' + '<button type = "button" class = "button" id="' + result[i].nombre +
                    '" onclick="comprarItem(this.id)"  >Comprar</button>' + '</td> </tr>'
                );
            }
        },
        error: function (error) {
            alert("Sin datos de compra.");
            console.log(error);
        }
    });
}
function cerrarSession() {
    var token = localStorage.getItem('token');
    if (token) {
        $.ajax({
            type: 'POST',
            url: '/dsaApp/game/cerrarSession',
            headers: {
                'Authorization': 'Bearer ' + token
            },
            success: function(result) {
                localStorage.clear();
                redirigirALoginT();
            },
            error: function(error) {
                console.log(error);
                localStorage.clear();
                redirigirALoginT();
            }
        });
    } else {
        localStorage.clear();
        redirigirALoginT();
    }
}
function comprarItem(itemId) {
    if (confirm("Seguro que quieres comprar este item?")) {
        var userName = localStorage.getItem("correo");
        $.ajax({
            type: 'POST',
            url: "/dsaApp/game/compraObjetos/" + userName + "/" + itemId,
            dataType: 'json',
            success: function (result) {
                window.location.href = "Tienda.html";
                getUser();
                alert('Compra correcta');
            },
            error: function (error) {
                window.location.href = "Tienda.html";
                getUser();
                alert('Compra correcta');
            },
        });
    }
}
function getUser() {
    var token = localStorage.getItem('token');
    var correo = localStorage.getItem("correo");
    if (!token) {
        redirigirALoginM();
        return;
    }
    $.ajax({
        type: 'GET',
        url: "/dsaApp/game/datosUsuario/"+correo,
        dataType: 'json',
        success: function (result) {
            localStorage.setItem('coins', result.dsacoins)
            $("#coins").text("Coins: " + result.dsacoins );
        },
        error: function (error) {
            alert("Sin datos de compra.");
            console.log(error);
        }
    });
};