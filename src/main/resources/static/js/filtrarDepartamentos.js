function filtrarDepartamentos() {
    const switchElement = document.getElementById("switch-departamentos");
    const filas = document.querySelectorAll("tbody tr.estado.inhabilitado");

    console.log("Switch activado:", switchElement.checked);

    filas.forEach(fila => {
        fila.style.display = switchElement.checked ? "none" : "";
    });
}
