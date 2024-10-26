 function validarFormulario() {
    var nombreCiudad = document.getElementById("nombreCiudad").value;

    var regexLetras = /^[a-zA-ZáéíóúÁÉÍÓÚñÑ\s]+$/;

    if (nombreCiudad.trim() === "") {
        alert("El campo Nombre de la ciudad es obligatorio.");
        return false;
    }

    if (!regexLetras.test(nombreCiudad)) {
        alert("El nombre de la ciudad solo puede contener letras y espacios.");
        return false;
    }

    return true;
}