function validarFormulario() {
    var email = document.getElementById("email").value;
    var contrasena = document.getElementById("contrasena").value;

    var regexEmail = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

    if (!regexEmail.test(email)) {
        alert("Por favor, ingresa un correo electrónico válido.");
        return false;
    }

    return true;
}