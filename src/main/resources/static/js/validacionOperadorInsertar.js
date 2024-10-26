function validarFormulario() {
    // Obtener los valores de los campos
    var cedula = document.getElementById("cedula").value;
    var nombre1 = document.getElementById("nombre1").value;
    var apellido1 = document.getElementById("apellido1").value;
    var telefono = document.getElementById("telefono").value;
    var correoElectronico = document.getElementById("correoElectronico").value;

    // Expresiones regulares para validación
    var regexCedula = /^[0-9]{1,11}$/; // Solo números con máximo de 11 dígitos
    var regexTelefono = /^[0-9]+$/; // Solo números para teléfono
    var regexCorreo = /^[^\s@]+@[^\s@]+\.[^\s@]+$/; // Formato de correo electrónico

    // Validar campos vacíos
    if (cedula == "" || nombre1 == "" || apellido1 == "" || telefono == "" || correoElectronico == "") {
        alert("Cédula, Primer Nombre, Primer Apellido, Teléfono y Correo Electrónico son obligatorios");
        return false;
    }

    // Validar cédula (solo números y máximo 11)
    if (!regexCedula.test(cedula)) {
        alert("La cédula debe contener solo números y un máximo de 11 dígitos");
        return false;
    }

    // Validar teléfono (solo números)
    if (!regexTelefono.test(telefono)) {
        alert("El teléfono debe contener solo números");
        return false;
    }

    // Validar correo electrónico (formato correcto)
    if (!regexCorreo.test(correoElectronico)) {
        alert("El correo electrónico no tiene un formato válido");
        return false;
    }

    // Si todas las validaciones pasan, se envía el formulario
    return true;
}
