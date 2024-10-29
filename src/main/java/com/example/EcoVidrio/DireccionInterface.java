package com.example.EcoVidrio;

import java.util.List;

public interface DireccionInterface {
    void guardarDireccion(Direccion direccion);
    List<Direccion> listadoDirecciones();
    Direccion consultar(int id);
    void eliminar(int id);
    
    // Nuevos métodos para inhabilitar y habilitar direcciones
    void inhabilitarDireccion(int id);
    void habilitarDireccion(int id);
    List<Direccion> obtenerDireccionesHabilitadas();
}
