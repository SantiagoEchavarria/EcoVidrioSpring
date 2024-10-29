package com.example.EcoVidrio;

import java.util.List;

public interface CiudadInterface {
    void guardarCiudad(Ciudad ciudad);
    List<Ciudad> listadoCiudades();
    Ciudad consultar(int id);
    void eliminar(int id);
    void inhabilitar(int id); 
    void habilitarCiudad(int id); 
    List<Ciudad> obtenerCiudadesHabilitadasPorDepartamento(Long departamentoId);
}
