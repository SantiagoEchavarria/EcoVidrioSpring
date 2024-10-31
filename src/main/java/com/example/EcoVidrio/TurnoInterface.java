package com.example.EcoVidrio;

import java.util.List;

public interface TurnoInterface {
    void guardarTurno(Turno turno);
    List<Turno> listadoTurnos();
    List<Turno> obteneTurnosHabilitados();
    Turno consultar(int id);
    void eliminar(int id);
    void inhabilitarTurno(int id);  // Método para inhabilitar un turno
    void habilitarTurno(int id);     // Método para habilitar un turno
}
