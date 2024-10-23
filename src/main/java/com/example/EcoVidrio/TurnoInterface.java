package com.example.EcoVidrio;

import java.util.List;

public interface TurnoInterface {
    void guardarTurno(Turno turno);
    List<Turno> listadoTurnos();
    public Turno consultar(int id);
	public void eliminar(int id);
}
