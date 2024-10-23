function validarFormulario() {
    var nombreDireccion = document.getElementById("nombreDireccion").value;
    var regexLetras = /^[a-zA-ZáéíóúÁÉÍÓÚñÑ\s]+$/;

    if (nombreDireccion.trim() === "") {
        alert("El campo Nombre de la dirección es obligatorio.");
        return false;
    }

    if (!regexLetras.test(nombreDireccion)) {
        alert("El nombre de la dirección solo puede contener letras y espacios.");
        return false;
    }

    return true;
}