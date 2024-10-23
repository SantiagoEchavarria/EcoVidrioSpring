function validarFormulario() {
    var nombreDepartamento = document.getElementById("nombreDepartamento").value;

    // Expresión regular para validar solo letras y espacios
    var regexLetras = /^[a-zA-ZáéíóúÁÉÍÓÚñÑ\s]+$/;

    // Validar que el campo no esté vacío
    if (nombreDepartamento.trim() === "") {
        alert("El campo Nombre del departamento es obligatorio.");
        return false;
    }

    // Validar que solo contenga letras y espacios
    if (!regexLetras.test(nombreDepartamento)) {
        alert("El nombre del departamento solo puede contener letras y espacios.");
        return false;
    }

    // Si todo está bien, permitir el envío del formulario
    return true;
}