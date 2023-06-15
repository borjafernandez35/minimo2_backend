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
function listaInventario() {
    var token = localStorage.getItem('token');
    var correo = localStorage.getItem("correo");
    if (!token) {
        redirigirALoginT();
        return;
    }
    $("#tcuerpo").empty();
    $.ajax({
        type: 'GET',
        url: "/dsaApp/game/listaObjetosUsuario/"+correo,
        dataType: 'json',
        success: function (result) {
            if (result.length != 0) {
                for (let i = 0; i < result.length; i++) {
                    console.log("i: " + i, result[i]);
                    $("#tabla").append(
                        "<tr> <td>" + result[i].nombreobjeto +
                        "</td></tr>"
                    );
                }
            }
            else {
                alert("No tienes ningún objeto en tu inventario.")
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