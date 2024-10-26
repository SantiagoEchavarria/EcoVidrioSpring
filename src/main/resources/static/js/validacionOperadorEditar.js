function validarFormulario() {
    // Obtener los valores de los campos
    var nombre1 = document.getElementById("nombre1").value;
    var apellido1 = document.getElementById("apellido1").value;
    var telefono = document.getElementById("telefono").value;
    var correoElectronico = document.getElementById("correoElectronico").value;

    // Expresiones regulares para validación
   
    var regexTelefono = /^[0-9]+$/; // Solo números para teléfono
    var regexCorreo = /^[^\s@]+@[^\s@]+\.[^\s@]+$/; // Formato de correo electrónico

    // Validar campos vacíos
    if ( nombre1 == "" || apellido1 == "" || telefono == "" || correoElectronico == "") {
        alert("Primer Nombre, Primer Apellido, Teléfono y Correo Electrónico son obligatorios");
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
