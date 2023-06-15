localStorage.clear();
/*function redirigirALogin() {
    if (window.location.pathname !== "/Login.html") {
        window.location.href = "Login.html";
    }
}
function redirigirATienda() {
    if (window.location.pathname !== "/Tienda.html") {
        window.location.href = "Tienda.html";
    }
}
function redirigirARegister() {
    if (window.location.pathname !== "/Register.html") {
        window.location.href = "Register.html";
    }
}
function redirigirAIndex() {
    if (window.location.pathname !== "/Index.html") {
        window.location.href = "Index.html";
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
                localStorage.removeItem('token');
                redirigirALogin();
            },
            error: function(error) {
                console.log(error);
                localStorage.removeItem('token');
                redirigirALogin();
            }
        });
    } else {
        localStorage.removeItem('token');
        redirigirALogin();
    }
}
function logear(){
    var correo = $('#usuario').val();
    var password = $('#contrasena').val();
    $.ajax({
        contentType: "application/json",
        type: 'POST',
        url: '/dsaApp/game/login',
        data: JSON.stringify({ "correo": correo, "password": password }),
        dataType: 'json',
        success: function(result){
            localStorage.setItem('token', result.token);
            redirigirATienda()
        },
        error: function(error){
            if (correo == "" || password == "")
                alert("Te has dejado algo en blaco, compruebalo de nuevo!");
            else{
                alert("Correo o contraseña incorrecta, prueba de nuevo!");
            }
        }
    });
}
function verificarSesion() {
    var token = localStorage.getItem('token');
    if (!token) {
        redirigirALogin();
        return;
    }
    else {
        return;
    }
}
function registrar() {
    var username = $('#usuario').val();
    var password = $('#contrasena').val();
    var password2 = $('#contrasena2').val();
    var email = $('#email').val();
    if (password == password2) {

        $.ajax({
            contentType: "application/json",
            type: 'POST',
            url: '/dsaApp/game/registrarUsuario',
            data: JSON.stringify({"nombre": username, "correo": email, "password": password}),
            dataType: 'json',
            success: function (result) {
                redirigirALogin();
            },
            error: function (error) {
                console.log(error);
                if (email == null || username == null || password == null)
                    alert("Has dejado algo en blanco, miralo de nuevo!");
                else
                    alert("Usuario o contraseña ya estan siendo usados, prueba de nuevo!");
            }
        });
    } else alert("Comprueba que las dos contraseñas son iguales.");
}
function listadeObjetos() {
    var token = localStorage.getItem('token');
    if (!token) {
        window.location.href = "Login.html";
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
                    "</td> <td>" + result[i].precio
                );
            }
        },
        error: function (error) {
            alert("Sin datos de compra.");
            console.log(error);
        }
    });
}*/