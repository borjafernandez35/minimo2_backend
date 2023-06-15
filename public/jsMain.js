verificarSesion();
getUser();
function redirigirALoginM() {
    if (window.location.pathname !== "/Login.html") {
        window.location.href = "Login.html";
    }
}
function verificarSesion() {
    var token = localStorage.getItem('token');
    if (!token) {
        redirigirALoginM();
        return;
    }
    else {
        return;
    }
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
                redirigirALoginM();
            },
            error: function(error) {
                console.log(error);
                localStorage.clear();
                redirigirALoginM();
            }
        });
    } else {
        localStorage.clear();
        redirigirALoginM();
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
            $("#user").text("Usuario: " + result.nombre);
            $("#coins").text("Coins: " + result.dsacoins);
            localStorage.setItem('coins', result.dsacoins)
        },
        error: function (error) {
            alert("Sin datos de compra.");
            console.log(error);
        }
    });
}