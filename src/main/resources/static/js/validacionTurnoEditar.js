function validarFormulario() {
    // Obtener los valores de los campos
    var nombre = document.getElementById("nombre").value;
    var horaEntrada = document.getElementById("hora_entrada").value;
    var horaSalida = document.getElementById("hora_salida").value;

    // Expresión regular para validar la hora en formato HH:MM
    var regexHora = /^([01]\d|2[0-3]):([0-5]\d)$/; 

    // Validar campos vacíos
    if (nombre == "" || horaEntrada == "" || horaSalida == "") {
        alert("Todos los campos son obligatorios");
        return false;
    }

    // Validar nombre (máximo 80 caracteres)
    if (nombre.length > 80) {
        alert("El nombre no debe exceder los 80 caracteres");
        return false;
    }

    // Validar formato de la hora de entrada
    if (!regexHora.test(horaEntrada)) {
        alert("La hora de entrada debe estar en formato HH:MM");
        return false;
    }

    // Validar formato de la hora de salida
    if (!regexHora.test(horaSalida)) {
        alert("La hora de salida debe estar en formato HH:MM");
        return false;
    }

    // Si todas las validaciones pasan, se envía el formulario
    return true;
}